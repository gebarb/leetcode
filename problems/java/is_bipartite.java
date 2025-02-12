/*
 * 785. Is Graph Bipartite?
 */

class Solution {

  public boolean isBipartite(int[][] graph) {
    // Red = 0, Blue = 1
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);

    for (int i = 0; i < graph.length; i++) {
      // BFS to check conflicting edges for Bipartite Graph exist
      if (color[i] == -1 && !bfs(i, graph, color)) {
        return false;
      }
    }
    return true;
  }

  private boolean bfs(int node, int[][] graph, int[] color) {
    Queue<Integer> neighbors = new ArrayDeque<>(List.of(node));
    color[node] = 0;

    while (!neighbors.isEmpty()) {
      int curr = neighbors.poll();
      for (int neighbor : graph[curr]) {
        if (color[neighbor] == color[curr]) {
          return false;
        }
        if (color[neighbor] == -1) {
          color[neighbor] = 1 - color[curr];
          neighbors.add(neighbor);
        }
      }
    }
    return true;
  }
}
