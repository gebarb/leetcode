/*
 * 27. Remove Element
 */

function removeElement(nums: number[], val: number): number {
  let k: number = 0;
  for (const n of nums) {
    if (n !== val) {
      nums[k++] = n;
    }
  }
  return k;
}
