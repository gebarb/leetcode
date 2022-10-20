/*
* 53. Maximum Subarray
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
