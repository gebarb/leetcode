/*
 * 1129. Shortest Path with Alternating Colors
 */

class Solution {

  private void buildGraph(
    int[][] graph,
    int n,
    int[][] red_edges,
    int[][] blue_edges
  ) {
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], -n);
    }

    for (int[] edge : red_edges) {
      int from = edge[0];
      int to = edge[1];
      graph[from][to] = 1;
    }

    for (int[] edge : blue_edges) {
      int from = edge[0];
      int to = edge[1];
      if (graph[from][to] == 1) {
        graph[from][to] = 0;
      } else {
        graph[from][to] = -1;
      }
    }
  }

  public int[] shortestAlternatingPaths(
    int n,
    int[][] red_edges,
    int[][] blue_edges
  ) {
    int[][] graph = new int[n][n];
    // Must build graph before we can find paths
    buildGraph(graph, n, red_edges, blue_edges);

    Queue<int[]> nodes = new LinkedList<>();
    nodes.offer(new int[] { 0, 1 });
    nodes.offer(new int[] { 0, -1 });
    int len = 0;
    int[] answer = new int[n];
    // Init answers array
    Arrays.fill(answer, Integer.MAX_VALUE);
    answer[0] = 0;

    Set<String> visited = new HashSet<>();
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      len++;
      for (int i = 0; i < size; i++) {
        int[] curr_node = nodes.poll();
        int tmp = curr_node[0];
        int color = curr_node[1];
        int alt_color = -color;

        for (int j = 1; j < n; j++) {
          if ((graph[tmp][j] == alt_color) || (graph[tmp][j] == 0)) {
            if (!visited.add("" + j + alt_color)) {
              continue;
            }
            nodes.offer(new int[] { j, alt_color });
            answer[j] = Math.min(answer[j], len);
          }
        }
      }
    }

    for (int i = 1; i < n; i++) {
      if (answer[i] == Integer.MAX_VALUE) {
        answer[i] = -1;
      }
    }

    return answer;
  }
}
