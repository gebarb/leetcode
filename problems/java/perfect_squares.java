/*
 * 279. Perfect Squares
 */

class Solution {

  public int numSquares(int n) {
    // According to Lagranges Four Square Theorem (Bachet's Conjecture)
    // Every element of N {Natural} can be represented as:
    // e = a^2 + b^2 + c^2 + d^2

    // If n is already a Perfect Square
    if (n == (Math.pow((int) Math.sqrt(n), 2))) {
      return 1;
    }

    // According to Legendre's Three-Square Theorem
    // n can be expressed as:
    // Sum of Three Squares iff not of the form 4^{k}(8m+7)
    while ((n & 3) == 0) { // (n & 3) == (n % 4)
      n >>= 2;
    }
    if ((n & 7) == 7) { // (n & 7) == (n % 8)
      return 4;
    }

    // Check if we can find a complement
    for (int i = 1; i <= (int) Math.sqrt(n); i++) {
      if (
        (n - Math.pow(i, 2)) ==
        (Math.pow((int) Math.sqrt(n - Math.pow(i, 2)), 2))
      ) {
        return 2;
      }
    }

    // Otherwise
    return 3;
  }
}
