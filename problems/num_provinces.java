/*
 * 547. Number of Provinces
 */
class Solution {

  public int findCircleNum(int[][] isConnected) {
    // To Find # Provinces is to Find Number of Connected Components in Graph
    boolean[] visited = new boolean[isConnected.length];
    int num_provinces = 0;

    for (int i = 0; i < isConnected.length; i++) {
      if (!visited[i]) {
        num_provinces++;
        dfs(isConnected, i, visited);
      }
    }
    return num_provinces;
  }

  private void dfs(int[][] isConnected, int i, boolean[] visited) {
    for (int j = 0; j < isConnected[i].length; j++) {
      if (!visited[j] && isConnected[i][j] != 0) {
        visited[j] = true;
        dfs(isConnected, j, visited);
      }
    }
  }
}
