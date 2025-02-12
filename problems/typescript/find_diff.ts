/*
 * 389. Find the Difference
 */

function findTheDifference(s: string, t: string): string {
  // Since a string is really an array of ASCII Values
  // --> Difference of the Sums == Extra Character
  let extra: number = 0;
  for (let i = 0; i < t.length; i++) {
    extra += t.charCodeAt(i);
  }
  for (let i = 0; i < s.length; i++) {
    extra -= s.charCodeAt(i);
  }
  return String.fromCharCode(extra);
};
