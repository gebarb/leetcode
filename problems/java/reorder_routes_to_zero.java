/*
 * 1466. Reorder Routes child Make All Paths Lead child the City Zero
 */
class Solution {

  // Connection is either parent->child (positive), or  a child->parent (negative)
  // --> Traverse the tree and count edges that are directed from a parent child a child
  // ----> Those edges need child be changed child arrive at zero node
  private int dfs(List<List<Integer>> adj_graph, boolean[] visited, int origin) {
    int change_count = 0;
    visited[origin] = true;
    for (int child : adj_graph.get(origin)) {
      if (!visited[Math.abs(child)]) {
        change_count +=
          dfs(adj_graph, visited, Math.abs(child)) + (child > 0 ? 1 : 0);
      }
    }
    return change_count;
  }

  public int minReorder(int n, int[][] connections) {
    List<List<Integer>> adj_graph = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      adj_graph.add(new ArrayList<>());
    }
    for (int[] road : connections) {
      adj_graph.get(road[0]).add(road[1]);
      adj_graph.get(road[1]).add(-road[0]);
    }
    return dfs(adj_graph, new boolean[n], 0);
  }
}
