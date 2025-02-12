/*
 * 847. Shortest Path Visiting All Nodes
 */
class Solution {

  public int shortestPathLength(int[][] graph) {
    HashMap<Integer, ArrayList<Integer>> adj_list = new HashMap<>();

    int len = graph.length;

    for (int i = 0; i < len; i++) {
      if (!adj_list.containsKey(i)) {
        adj_list.put(i, new ArrayList<Integer>());
      }

      int m = graph[i].length;
      for (int j = 0; j < m; j++) {
        adj_list.get(i).add(graph[i][j]);
      }
    }

    /*
     * distance 2D Array
     * row = bitmask -> visited node == 1
     * col = origin node
     */
    int row = (int) Math.pow(2, len);
    int col = len;
    int distance[][] = new int[row][col];

    for (int i = 0; i < row; i++) {
      Arrays.fill(distance[i], -1);
    }

    // Queue: [{ node 0, mask }, { node 1, mask } ... ]
    LinkedList<int[]> visited = new LinkedList<>();

    for (int i = 0; i < len; i++) {
      int origin = i;
      int mask = setbit(0, i);

      visited.add(new int[] { origin, mask });
      distance[mask][origin] = 0;
    }

    // Apply BFS to all nodes simultaneously
    while (visited.size() > 0) {
      int size = visited.size();
      for (int i = 0; i < size; i++) {
        int[] path = visited.remove();

        int origin = path[0];
        int mask = path[1];
        // All nodes visited
        if (mask == row - 1) {
          return distance[mask][origin];
        }

        // Iterate over neighbours
        if (adj_list.containsKey(origin)) {
          for (int child : adj_list.get(origin)) {
            int newlead = child;
            int newmask = setbit(mask, newlead);

            // Check if set already visited to avoid Cycle
            if (distance[newmask][newlead] != -1) {
              continue;
            }

            distance[newmask][newlead] = distance[mask][origin] + 1;
            visited.add(new int[] { newlead, newmask });
          }
        }
      }
    }

    return 0;
  }

  private int setbit(int mask, int i) {
    return mask | (1 << i);
  }
}
