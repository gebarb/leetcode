/*
 * 1020. Number of Enclaves
 */

class Solution {

  public void dfs_fill(int[][] grid, int i, int j) {
    if (
      (i < 0) ||
      (j < 0) ||
      (i >= grid.length) ||
      (j >= grid[0].length) ||
      (grid[i][j] == 0)
    ) {
      return;
    }
    grid[i][j] = 0;

    dfs_fill(grid, i + 1, j);
    dfs_fill(grid, i - 1, j);
    dfs_fill(grid, i, j + 1);
    dfs_fill(grid, i, j - 1);
  }

  public int numEnclaves(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (
          (((i == 0) || (j == 0) || (i == rows - 1) || (j == cols - 1))) &&
          (grid[i][j] == 1)
        ) {
          dfs_fill(grid, i, j);
        }
      }
    }

    int num_enclaves = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) num_enclaves++;
      }
    }
    return num_enclaves;
  }
}
