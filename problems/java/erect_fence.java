/*
 * 587. Erect the Fence
 */

public class Solution {

  public int vector_orient(int[] p, int[] q, int[] r) {
    return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
  }

  // Monotone Chain Algorithm
  public int[][] outerTrees(int[][] trees) {
    Stack<int[]> upper_hull = new Stack<>();
    Stack<int[]> lower_hull = new Stack<>();
    Arrays.sort(trees, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
    for (int i = 0; i < trees.length; i++) {
      while (
        lower_hull.size() >= 2 &&
        vector_orient(
          lower_hull.get(lower_hull.size() - 2),
          lower_hull.get(lower_hull.size() - 1),
          trees[i]
        ) >
        0
      ) {
        lower_hull.pop();
      }
      while (
        upper_hull.size() >= 2 &&
        vector_orient(
          upper_hull.get(upper_hull.size() - 2),
          upper_hull.get(upper_hull.size() - 1),
          trees[i]
        ) <
        0
      ) {
        upper_hull.pop();
      }
      lower_hull.push(trees[i]);
      upper_hull.push(trees[i]);
    }
    Set<int[]> fence = new HashSet<>(lower_hull);
    fence.addAll(upper_hull);
    return fence.toArray(new int[fence.size()][]);
  }
}
