/*
 * 120. Triangle
 */

class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int[][] sum = new int[rows + 1][rows + 1];

    // Loop to sum the mins
    for (int i = rows - 1; i >= 0; i--) {
      // Loop to select min number per row
      for (int row = 0; row <= i; row++) {
        sum[i][row] =
          Math.min(sum[i + 1][row], sum[i + 1][row + 1]) +
          triangle.get(i).get(row);
      }
    }
    return sum[0][0];
  }
}
