/*
 * 802. Find Eventual Safe States
 */

class Solution {

  // White-Gray-Black DFS
  public List<Integer> eventualSafeNodes(int[][] graph) {
    // If can reach Cycle from Current Node
    // --> Current Node is SAFE
    int[] color = new int[graph.length];
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < graph.length; ++i) if (dfs(i, color, graph)) ans.add(i);
    return ans;
  }

  // White = 0 (Unseen), Gray = 1 (Entry), Black = 2 (Exit)
  public boolean dfs(int i, int[] color, int[][] graph) {
    if (color[i] > 0) {
      return color[i] == 2;
    }
    color[i] = 1;
    for (int node : graph[i]) {
      if (color[i] == 2) {
        continue;
      }
      if ((color[node] == 1) || (!dfs(node, color, graph))) {
        return false;
      }
    }

    color[i] = 2;
    return true;
  }
}
