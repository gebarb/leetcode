/*
 * 7. Reverse Integer
 */

class Solution {

  public int reverse(int x) {
    int reversed = 0;
    while (x != 0) {
      // Maintain Digit but Change Place Value
      int translation = x % 10;
      x /= 10;
      if (
        reversed > (Integer.MAX_VALUE / 10) ||
        (
          reversed == (Integer.MAX_VALUE / 10) &&
          // Int Max = 2147483647
          translation >
          7
        )
      ) {
        return 0;
      } else if (
        reversed < (Integer.MIN_VALUE / 10) ||
        (
          reversed == (Integer.MIN_VALUE / 10) &&
          // Int Min = -2147483648
          translation <
          -8
        )
      ) {
        return 0;
      }
      reversed = reversed * 10 + translation;
    }
    return reversed;
  }
}
