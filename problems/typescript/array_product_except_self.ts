/*
 * 238. Product of Array Except Self
 */

function productExceptSelf(nums: number[]): number[] {
  let answer: number[] = new Array(nums.length).fill(1);
  let multiple: number = 1;
  for (let i = 0; i < nums.length; i++) {
    answer[i] *= multiple;
    multiple *= nums[i];
  }
  multiple = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    answer[i] *= multiple;
    multiple *= nums[i];
  }
  return answer;
}
