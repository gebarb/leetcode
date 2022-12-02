/*
 * 1306. Jump Game III
 */

function canReach(arr: number[], start: number): boolean {

  if ((0 <= start) && (start < arr.length) && (arr[start] >= 0)) {
    // Trick to keep tracked of checked indexes
    arr[start] = -arr[start]
    return (arr[start] == 0) || (canReach(arr, start + arr[start])) || (canReach(arr, start - arr[start]))
  }
  return false;
};
