/*
* 1480. Running Sum of 1d Array
*/

function runningSum(nums: number[]): number[] {
    if (nums.length == 1)
        return nums;
    else {
        for (let i: number = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}