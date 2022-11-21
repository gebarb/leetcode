/*
 * 231. Power of Two
 */

class Solution {

  public boolean isPowerOfTwo(int n) {
    // Since Integers are expressed in binary...
    return (n > 0) && ((n & (n - 1)) == 0);
  }
}
