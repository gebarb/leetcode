/*
 * 752. Open the Lock
 */

class Solution {

  // Treat each digit in the combination as a node on a graph

  public int openLock(String[] deadends, String target) {
    if (target.equals("0000")) {
      return 0;
    }
    int unlock = Integer.parseInt(target);
    Queue<Integer> combinations = new LinkedList<>();
    boolean[] seen = new boolean[10000];
    combinations.add(0);
    for (String deadend : deadends) {
      seen[Integer.parseInt(deadend)] = true;
    }
    if (seen[0]) {
      return -1;
    }
    for (int turns = 1; !combinations.isEmpty(); turns++) {
      int qlen = combinations.size();
      for (int i = 0; i < qlen; i++) {
        int curr = combinations.poll();
        // Total of 10^4 possible combinations
        for (int j = 1; j < 10000; j *= 10) {
          int mask = curr % (j * 10) / j;
          int masked = curr - (mask * j);
          for (int k = 1; k < 10; k += 8) {
            int next = masked + (mask + k) % 10 * j;
            if (seen[next]) {
              continue;
            }
            if (next == unlock) {
              return turns;
            }
            seen[next] = true;
            combinations.add(next);
          }
        }
      }
    }
    return -1;
  }
}
