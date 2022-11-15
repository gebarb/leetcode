/*
 * 695. Max Area of Island
 */

class Solution {

  int[][] grid;
  boolean[][] seen;

  public int calcArea(int r, int c) {
    // Check Boundaries & History
    if (
      r < 0 ||
      r >= grid.length ||
      c < 0 ||
      c >= grid[0].length ||
      seen[r][c] ||
      grid[r][c] == 0
    ) {
      return 0;
    }
    seen[r][c] = true;
    return (
      1 +
      calcArea(r + 1, c) +
      calcArea(r - 1, c) +
      calcArea(r, c - 1) +
      calcArea(r, c + 1)
    );
  }

  public int maxAreaOfIsland(int[][] grid) {
    this.grid = grid;
    seen = new boolean[grid.length][grid[0].length];
    int max_area = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        max_area = Math.max(max_area, calcArea(r, c));
      }
    }
    return max_area;
  }
}
