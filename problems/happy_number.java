/*
 * 202. Happy Number
 */

class Solution {

  public int replace(int n) {
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      n = n / 10;
      sum += Math.pow(digit, 2);
    }
    return sum;
  }

  public boolean isHappy(int n) {
    /*
     * Consider Set of Largest:
     * 9 -> 81; 99 -> 162; 999 -> 243; 9999 -> 324 ... 9999999999999	-> 1053
     * ; Numbers with 4+ Digits will repeatedly lose digits
     * ; Numbers with 3 Digits must be less than 243
     * ;; Numbers with 3 Digits will eventually hit a cycle below 243, or go down to 1
     * ;;; There Exists only a single cycle:
     *     4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4
     */
    Set<Integer> cycle = new HashSet<>(
      Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20)
    );
    while (n != 1 && !cycle.contains(n)) {
      n = replace(n);
    }
    return n == 1;
  }
}
