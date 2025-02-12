/*
 * 1254. Number of Closed Islands
 */

class Solution {

  int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public boolean dfs_fill(int[][] grid, int m, int n) {
    if ((m < 0) || (m >= grid.length) || (n < 0) || (n >= grid[0].length)) {
      return false;
    }
    if (grid[m][n] == 1) {
      return true;
    }
    grid[m][n] = 1;

    boolean closed_isle = true;

    for (int[] dir : DIRECTIONS) {
      closed_isle = closed_isle & dfs_fill(grid, m + dir[0], n + dir[1]);
    }

    return closed_isle;
  }

  public int closedIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int num_isle = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (dfs_fill(grid, i, j)) {
            num_isle++;
          }
        }
      }
    }
    return num_isle;
  }
}
