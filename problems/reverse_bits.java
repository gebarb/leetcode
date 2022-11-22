/*
 * 190. Reverse Bits
 */

public class Solution {

  public int reverseBits(int n) {
    int reversed = 0;
    for (int i = 0; i < 32; i++) {
      // Add last bit of n to reversed
      reversed = (reversed << 1) | (n & 1);
      // Shift last bit off n
      n >>= 1;
    }
    return reversed;
  }
}
