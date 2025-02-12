/*
* 724. Find Pivot Index
*/

function pivotIndex(nums: number[]): number {
    const sum: number = nums.reduce((sum, n) => {
        return sum + n;
    }, 0);
    let left_sum: number = 0;

    for (let i: number = 0; i < nums.length; i++) {
        if ((sum - left_sum - nums[i]) === left_sum) {
            return i;
        }
        left_sum += nums[i];
    }
    return -1;
};