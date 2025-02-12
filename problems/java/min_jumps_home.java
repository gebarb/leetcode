/*
 * 1654. Minimum Jumps to Reach Home
 */

class Solution {

  public int minimumJumps(int[] forbidden, int a, int b, int x) {
    PriorityQueue<int[]> jumps = new PriorityQueue<>((i, j) -> i[0] - j[0]);
    // { <step>, <current index>, <direction> }
    jumps.offer(new int[] { 0, 0, 0 });
    Set<Integer> illegal = new HashSet<>();
    Set<String> visited = new HashSet<>();

    // Init set of Forbidden Indexes
    int maxLimit = 2000 + 2 * b;
    for (int num : forbidden) {
      illegal.add(num);
      maxLimit = Math.max(maxLimit, num + 2 * b);
    }

    while (!jumps.isEmpty()) {
      int[] pos = jumps.poll();
      int step = pos[0];
      int idx = pos[1];
      int dir = pos[2];
      if (idx == x) {
        return step;
      }
      // Jump Forward
      if (
        (idx + a < maxLimit) &&
        (!illegal.contains(idx + a)) &&
        (!visited.contains(idx + a + "," + 0))
      ) {
        visited.add(idx + a + "," + 0);
        jumps.offer(new int[] { step + 1, idx + a, 0 });
      }
      // Jump Backward
      if (
        (idx - b >= 0) &&
        (!illegal.contains(idx - b)) &&
        (!visited.contains(idx - b + "," + 1)) &&
        (dir != 1)
      ) {
        visited.add(idx - b + "," + 1);
        jumps.offer(new int[] { step + 1, idx - b, 1 });
      }
    }
    return -1;
  }
}
