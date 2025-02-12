/*
 * 994. Rotting Oranges
 */

class Solution {

  int[][] DIRECTION = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    Queue<int[]> oranges = new LinkedList<>();
    int num_fresh = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == 2) {
          oranges.offer(new int[] { row, col });
        } else if (grid[row][col] == 1) {
          num_fresh++;
        }
      }
    }
    if (num_fresh == 0) {
      return 0;
    }

    int num_min = 0;

    while (!oranges.isEmpty()) {
      if (num_fresh == 0) {
        return num_min;
      } else {
        num_min++;
      }
      int basket = oranges.size();
      for (int i = 0; i < basket; i++) {
        int[] orange = oranges.poll();
        for (int dir[] : DIRECTION) {
          int x = orange[0] + dir[0];
          int y = orange[1] + dir[1];
          if (
            x < 0 ||
            x >= grid.length ||
            y < 0 ||
            y >= grid[0].length ||
            grid[x][y] == 2 ||
            grid[x][y] == 0
          ) {
            continue;
          }
          grid[x][y] = 2;
          oranges.offer(new int[] { x, y });
          num_fresh--;
        }
      }
    }
    return num_fresh == 0 ? num_min : -1;
  }
}
