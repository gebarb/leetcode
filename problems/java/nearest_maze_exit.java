/*
 * 1926. Nearest Exit from Entrance in Maze
 */

class Solution {

  int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int nearestExit(char[][] maze, int[] entrance) {
    int rows = maze.length;
    int cols = maze[0].length;

    maze[entrance[0]][entrance[1]] = '+';
    Queue<int[]> visited = new LinkedList<>();
    visited.offer(new int[] { entrance[0], entrance[1], 0 });

    while (!visited.isEmpty()) {
      int[] curr = visited.poll();
      int curr_row = curr[0];
      int curr_col = curr[1];
      int curr_dist = curr[2];

      for (int[] dir : DIRECTIONS) {
        int next_row = curr_row + dir[0];
        int next_col = curr_col + dir[1];
        // Visit all unvisited neighbors
        if (
          (0 <= next_row) &&
          (next_row < rows) &&
          (0 <= next_col) &&
          (next_col < cols) &&
          (maze[next_row][next_col] == '.')
        ) {
          // Check if this is an exit
          if (
            (next_row == 0) ||
            (next_row == rows - 1) ||
            (next_col == 0) ||
            (next_col == cols - 1)
          ) {
            return curr_dist + 1;
          } else {
            maze[next_row][next_col] = '+';
            visited.offer(new int[] { next_row, next_col, curr_dist + 1 });
          }
        }
      }
    }
    return -1;
  }
}
