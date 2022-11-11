/*
 * 8. String to Integer (atoi)
 */
class Solution {

  public int myAtoi(String s) {
    char[] digits = s.toCharArray();
    int sign = 1;
    double val = 0;
    int i = 0;

    // Skip leading whitespace
    while (i < digits.length && digits[i] == ' ') {
      i++;
    }
    if (i < digits.length) {
      // Positive or Negative?
      if (digits[i] == '-' || digits[i] == '+') {
        sign = digits[i++] == '-' ? -1 : 1;
      }
      for (; i < digits.length; i++) {
        // Only translate digits
        if (digits[i] >= '0' && digits[i] <= '9') {
          val = 10 * val + (digits[i] - '0');
          continue;
        } else {
          break;
        }
      }
    }
    val *= sign;
    return (val < Integer.MIN_VALUE)
      ? Integer.MIN_VALUE
      : (val > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) val;
  }
}
