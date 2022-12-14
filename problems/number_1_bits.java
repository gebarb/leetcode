/*
 * 191. Number of 1 Bits
 */

public class Solution {

  public int hammingWeight(int n) {
    int num_ones = 0;
    while (n != 0) {
      num_ones += n & 1;
      n = n >>> 1;
    }
    return num_ones;
  }
}
