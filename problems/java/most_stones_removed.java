/*
 * 947. Most Stones Removed with Same Row or Column
 */

class Solution {

  // Graph Theory!!
  public int removeStones(int[][] stones) {
    int n = stones.length;
    if (n <= 1) {
      return 0;
    }

    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      int[] curr_stone = stones[i];
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        int[] next_stone = stones[j];
        if (curr_stone[0] == next_stone[0] || curr_stone[1] == next_stone[1]) {
          graph[i].add(j);
        }
      }
    }

    boolean[] visited = new boolean[n];
    int count = 0;

    for (int k = 0; k < n; k++) {
      if (visited[k]) {
        continue;
      }

      dfs(graph, visited, k);
      count++;
    }

    return n - count;
  }

  private static void dfs(List<Integer>[] graph, boolean[] visited, int start) {
    visited[start] = true;

    List<Integer> neighbors = graph[start];
    for (int x : neighbors) {
      if (visited[x]) {
        continue;
      }

      dfs(graph, visited, x);
    }
  }
}
