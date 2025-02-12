/*
 * 417. Pacific Atlantic Water Flow
 */

public class Solution {

  int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public void dfs_fill(
    int[][] heights,
    boolean[][] visited,
    int height,
    int x,
    int y
  ) {
    int n = heights.length, m = heights[0].length;
    if (
      (x < 0) ||
      (x >= n) ||
      (y < 0) ||
      (y >= m) ||
      (visited[x][y]) ||
      (heights[x][y] < height)
    ) {
      return;
    }
    visited[x][y] = true;
    for (int[] d : DIRECTIONS) {
      dfs_fill(heights, visited, heights[x][y], x + d[0], y + d[1]);
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> watershed = new LinkedList<>();
    if (heights == null || heights.length == 0 || heights[0].length == 0) {
      return watershed;
    }
    int n = heights.length, m = heights[0].length;
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      dfs_fill(heights, pacific, Integer.MIN_VALUE, i, 0);
      dfs_fill(heights, atlantic, Integer.MIN_VALUE, i, m - 1);
    }
    for (int i = 0; i < m; i++) {
      dfs_fill(heights, pacific, Integer.MIN_VALUE, 0, i);
      dfs_fill(heights, atlantic, Integer.MIN_VALUE, n - 1, i);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          watershed.add(new ArrayList<Integer>(Arrays.asList(i, j)));
        }
      }
    }
    return watershed;
  }
}
