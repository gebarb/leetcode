/*
 * 374. Guess Number Higher or Lower
 */

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {

  public int guessNumber(int n) {
    int low_guess = 1;
    int high_guess = n;
    while (low_guess <= high_guess) {
      int mid = low_guess + ((high_guess - low_guess) / 2);
      if (guess(mid) == 1) {
        low_guess = mid + 1;
      } else if (guess(mid) == -1) {
        high_guess = mid - 1;
      } else {
        return mid;
      }
    }
    return 0;
  }
}
