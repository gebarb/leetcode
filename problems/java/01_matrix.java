/*
 * 542. 01 Matrix
 */

class Solution {

  int[] DIRECTION = new int[] { 0, 1, 0, -1, 0 };

  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    Queue<int[]> seen = new ArrayDeque<>();
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (mat[row][col] == 0) {
          seen.offer(new int[] { row, col });
        } else {
          mat[row][col] = -1;
        }
      }
    }
    while (!seen.isEmpty()) {
      int[] curr = seen.poll();
      int curr_row = curr[0];
      int curr_col = curr[1];
      for (int i = 0; i < 4; i++) {
        int row_prime = curr_row + DIRECTION[i];
        int col_prime = curr_col + DIRECTION[i + 1];
        if (
          row_prime < 0 ||
          row_prime == m ||
          col_prime < 0 ||
          col_prime == n ||
          mat[row_prime][col_prime] != -1
        ) {
          continue;
        }
        mat[row_prime][col_prime] = mat[curr_row][curr_col] + 1;
        seen.offer(new int[] { row_prime, col_prime });
      }
    }
    return mat;
  }
}
