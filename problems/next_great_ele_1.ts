/*
 * 496. Next Greater Element I
 */

function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
  let next_greater: number[] = new Array(nums1.length).fill(-1);
  for (let i: number = 0; i < nums1.length; i++) {
    for (let j: number = 0; j < nums2.length; j++) {
      if (nums1[i] == nums2[j]) {
        for (let k: number = j; k < nums2.length; k++) {
          if (nums2[k] > nums2[j]) {
            next_greater[i] = nums2[k];
            break;
          }
        }
      }
    }
  }
  return next_greater;
};