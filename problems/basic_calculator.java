/*
 * 224. Basic Calculator
 */
class Solution {

  public int calculate(String s) {
    if (s == null || s == "") {
      return 0;
    }

    int sign = 1;
    int num = 0;
    int eq = 0;

    Stack<Integer> ops = new Stack<Integer>();
    ops.push(sign);

    for (int i = 0; i < s.length(); i++) {
      char curr_char = s.charAt(i);

      if (curr_char >= '0' && curr_char <= '9') {
        num = num * 10 + (curr_char - '0');
      } else if (curr_char == '+' || curr_char == '-') {
        eq += sign * num;
        sign = ops.peek() * (curr_char == '+' ? 1 : -1);
        num = 0;
      } else if (curr_char == '(') {
        ops.push(sign);
      } else if (curr_char == ')') {
        ops.pop();
      }
    }

    eq += sign * num;
    return eq;
  }
}
