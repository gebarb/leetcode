/*
 * 1779. Find Nearest Point That Has the Same X or Y Coordinate
 */

class Solution {

  public int nearestValidPoint(int x, int y, int[][] points) {
    int nearest = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < points.length; ++i) {
      int dx = x - points[i][0];
      int dy = y - points[i][1];
      if (dx * dy == 0 && Math.abs(dy + dx) < nearest) {
        nearest = Math.abs(dx + dy);
        index = i;
      }
    }
    return index;
  }
}
