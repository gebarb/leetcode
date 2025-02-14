/*
* 53. Maximum Subarray
*
* Given an integer array nums, find the subarray with the largest sum, and return its sum.
* 
* Constraints:
* 1 <= nums.length <= 10^5
* -10^4 <= nums[i] <= 10^4
* 
*/

function maxSubArray(nums: number[]): number {
    let max_sum: number = nums[0];
    for (let i = 1; i < nums.length; i++) {
        nums[i] += Math.max(0, nums[i - 1]);
        if (nums[i] > max_sum)
            max_sum = nums[i];
    }
    return max_sum;
}
