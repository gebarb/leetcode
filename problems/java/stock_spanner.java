/*
 * 901. Online Stock Span
 */

class StockSpanner {

  Stack<int[]> monotonic_stack = new Stack<>();

  public int next(int price) {
    int span = 1;
    while (monotonic_stack.size() > 1 && monotonic_stack.peek()[0] <= price) {
      span += monotonic_stack.pop()[1];
    }

    monotonic_stack.push(new int[] { price, span });
    return span;
  }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
