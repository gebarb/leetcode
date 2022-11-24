/*
 * 1905. Count Sub Islands
 */
class Solution {

  int is_isle = 0;

  public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
    if (
      (i < 0) ||
      (i >= grid1.length) ||
      (j < 0) ||
      (j >= grid1[0].length) ||
      (grid2[i][j] == 0)
    ) {
      return;
    }
    if (grid1[i][j] == 0) {
      is_isle = 0;
    }
    grid2[i][j] = 0;
    dfs(grid1, grid2, i - 1, j);
    dfs(grid1, grid2, i + 1, j);
    dfs(grid1, grid2, i, j + 1);
    dfs(grid1, grid2, i, j - 1);
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int num_sub_isle = 0;
    for (int i = 0; i < grid1.length; i++) {
      for (int j = 0; j < grid2[0].length; j++) {
        if (grid2[i][j] == 1) {
          is_isle = 1;
          dfs(grid1, grid2, i, j);
          num_sub_isle += is_isle;
        }
      }
    }
    return num_sub_isle;
  }
}
