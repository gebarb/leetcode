/*
 * 886. Possible Bipartition
 */

class Solution {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    Map<Integer, List<Integer>> adj_list = new HashMap<>();
    for (int[] edge : dislikes) {
      adj_list
        .computeIfAbsent(edge[0], value -> new ArrayList<Integer>())
        .add(edge[1]);
      adj_list
        .computeIfAbsent(edge[1], value -> new ArrayList<Integer>())
        .add(edge[0]);
    }

    // Red = 0, Blue = 1
    int[] color = new int[n + 1];
    Arrays.fill(color, -1);

    for (int i = 1; i <= n; i++) {
      if (color[i] == -1) {
        // BFS to check conflicting edges for Bipartite Graph exist
        if (!bfs(i, adj_list, color)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean bfs(
    int source,
    Map<Integer, List<Integer>> adj_list,
    int[] color
  ) {
    Queue<Integer> neighbors = new LinkedList<>();
    neighbors.offer(source);
    // Source -> Red
    color[source] = 0;

    while (!neighbors.isEmpty()) {
      int neighbor = neighbors.poll();
      if (!adj_list.containsKey(neighbor)) {
        continue;
      }
      for (int node : adj_list.get(neighbor)) {
        if (color[node] == color[neighbor]) {
          return false;
        }
        if (color[node] == -1) {
          color[node] = 1 - color[neighbor];
          neighbors.add(node);
        }
      }
    }
    return true;
  }
}
