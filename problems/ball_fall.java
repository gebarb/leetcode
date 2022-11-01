/*
 * 1706. Where Will the Ball Fall
 */

class Solution {

  public int[] findBall(int[][] grid) {
    int simulation[] = new int[grid[0].length];

    for (int i = 0; i < grid[0].length; i++) {
      int curr_coll = i;
      for (int j = 0; j < grid.length; j++) {
        int next_col = curr_coll + grid[j][curr_coll];
        if (
          next_col < 0 ||
          next_col > grid[0].length - 1 ||
          grid[j][curr_coll] != grid[j][next_col]
        ) {
          simulation[i] = -1;
          break;
        }
        simulation[i] = next_col;
        curr_coll = next_col;
      }
    }
    return simulation;
  }
}
