/*
 * 934. Shortest Bridge
 */
class Solution {

  public int shortestBridge(int[][] grid) {
    Queue<int[]> isles = new LinkedList<>();
    boolean bridge_built = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          // Connected Islands
          dfs(grid, i, j, isles);
          bridge_built = true;
          break;
        }
      }
      if (bridge_built == true) {
        break;
      }
    }

    return findNearestIslandBFS(grid, isles);
  }

  private void dfs(int[][] grid, int i, int j, Queue<int[]> isles) {
    // Preorder DFS used to add the sub-land of island into Queue
    if (
      (i < 0) ||
      (i >= grid.length) ||
      (j < 0) ||
      (j >= grid[0].length) ||
      (grid[i][j]) == -1 ||
      (grid[i][j]) == 0
    ) {
      return;
    }
    grid[i][j] = -1;
    isles.offer(new int[] { i, j });
    dfs(grid, i - 1, j, isles);
    dfs(grid, i, j + 1, isles);
    dfs(grid, i + 1, j, isles);
    dfs(grid, i, j - 1, isles);
    return;
  }

  private int findNearestIslandBFS(int[][] grid, Queue<int[]> isles) {
    // BFS finds the shortest path length between two islands
    // AKA the Shortest Bridge
    int[][] DIRECTION = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int length = 0;

    while (!isles.isEmpty()) {
      int size = isles.size();
      while (size-- > 0) {
        int[] tmp = isles.poll();
        for (int[] dir : DIRECTION) {
          int x = tmp[0] + dir[0];
          int y = tmp[1] + dir[1];
          if (
            (x >= grid.length) ||
            (x < 0) ||
            (y >= grid[0].length) ||
            (y < 0) ||
            (grid[x][y] == -1)
          ) {
            continue;
          }
          if (grid[x][y] == 1) {
            return length;
          } else {
            grid[x][y] = -1;
            isles.offer(new int[] { x, y });
          }
        }
      }
      length += 1;
    }
    return -1;
  }
}
