/*
 * 1091. Shortest Path in Binary Matrix
 */

class Solution {

  int[][] DIRECTIONS = {
    { -1, -1 },
    { -1, 0 },
    { -1, 1 },
    { 0, -1 },
    { 0, 1 },
    { 1, -1 },
    { 1, 0 },
    { 1, 1 },
  };

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    int distance = 0;

    int rows = grid.length;
    int cols = grid[0].length;

    if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
      return -1;
    }

    boolean[][] visited = new boolean[rows][cols];

    Queue<int[]> path = new LinkedList<>();
    path.offer(new int[] { 0, 0 });
    visited[0][0] = true;

    while (!path.isEmpty()) {
      int size = path.size();
      distance++;

      for (int i = 0; i < size; i++) {
        int[] curr = path.poll();

        if (curr[0] == rows - 1 && curr[1] == cols - 1) {
          return distance;
        }

        for (int[] dir : DIRECTIONS) {
          int x = curr[0] + dir[0];
          int y = curr[1] + dir[1];

          if (
            (x < 0) ||
            (x >= rows) ||
            (y < 0) ||
            (y >= cols) ||
            (visited[x][y]) ||
            (grid[x][y]) == 1
          ) {
            continue;
          }

          visited[x][y] = true;
          path.offer(new int[] { x, y });
        }
      }
    }

    return -1;
  }
}
