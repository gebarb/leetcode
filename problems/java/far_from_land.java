/*
 * 1162. As Far from Land as Possible
 */

class Solution {

  public int maxDistance(int[][] matrix) {
    Queue<int[]> isles = new LinkedList<>();
    int[][] DIRECTIONS = new int[][] {
      { 1, 0 },
      { -1, 0 },
      { 0, 1 },
      { 0, -1 },
    };
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          // Sink land as it will be summed w/ Child
          matrix[i][j] = 0;
          isles.add(new int[] { i, j });
        } else {
          matrix[i][j] = Integer.MIN_VALUE;
        }
      }
    }
    while (!isles.isEmpty()) {
      int[] pos = isles.poll();
      for (int[] dir : DIRECTIONS) {
        int x = pos[0] + dir[0];
        int y = pos[1] + dir[1];
        if (
          (x >= 0) &&
          (y >= 0) &&
          (x < matrix.length) &&
          (y < matrix[0].length) &&
          (matrix[x][y] < 0)
        ) {
          isles.add(new int[] { x, y });
          matrix[x][y] = matrix[pos[0]][pos[1]] + 1;
          max = Math.max(max, matrix[x][y]);
        }
      }
    }
    return (max == Integer.MIN_VALUE) ? -1 : max;
  }
}
