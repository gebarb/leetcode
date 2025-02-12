/*
 * 9. Palindrome Number
 */

function isPalindrome(x: number): boolean {
  if (x < 0) {
    return false;
  }

  let reverse: number = 0;
  let tmp: number = x;
  // reverse the number by shifting decimal places
  while (tmp > 0) {
    reverse = reverse * 10 + (tmp % 10);
    tmp = Math.floor(tmp / 10);
  }

  return reverse === x;
}
