/*
 * 643. Maximum Average Subarray I
 */

function findMaxAverage(nums: number[], k: number): number {
  let windowSum: number = 0;
  let maxSum: number = 0;
  for (let i = 0; i < k; i++) {
    windowSum += nums[i];
  }
  maxSum = windowSum;
  for (let i = k; i < nums.length; i++) {
    windowSum += nums[i] - nums[i - k];
    maxSum = Math.max(maxSum, windowSum);
  }
  return maxSum / k;
}
