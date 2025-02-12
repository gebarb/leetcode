/*
 * 1615. Maximal Network Rank
 */

class Solution {

  public int maximalNetworkRank(int n, int[][] roads) {
    boolean[][] connected = new boolean[n][n];
    int[] ranks = new int[n];
    for (int[] road : roads) {
      // Establish Bi-Directional Connection between Cities i, j
      ranks[road[0]]++;
      ranks[road[1]]++;
      connected[road[0]][road[1]] = true;
      connected[road[1]][road[0]] = true;
    }
    int max_rank = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        max_rank =
          Math.max(max_rank, ranks[i] + ranks[j] - (connected[i][j] ? 1 : 0));
      }
    }
    return max_rank;
  }
}
