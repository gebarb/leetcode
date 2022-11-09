/*
* 35. Search Insert Position
*/

function searchInsert(nums: number[], target: number): number {
    let start: number = 0;
    let end: number = nums.length - 1;
    let midpoint: number = Math.floor((start + end) / 2);
    while (start <= end) {
        midpoint = Math.floor((start + end) / 2);
        if (nums[midpoint] == target) {
            return midpoint;
        }
        else if (nums[midpoint] > target) {
            end = midpoint - 1;
        }
        else {
            start = midpoint + 1;
        }
    }
    // If target is never found
    return end + 1;
};