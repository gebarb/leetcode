/*
* 1822. Sign of the Product of an Array
*/

function arraySign(nums: number[]): number {
    const product: number = nums.reduce((prod, n) => prod *= n, 1);
    if (product > 0) {
        return 1;
    }
    else if (product < 0) {
        return -1;
    }
    else {
        return 0;
    }
};