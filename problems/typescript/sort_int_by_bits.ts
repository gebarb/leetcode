/*
* 1356. Sort Integers by The Number of 1 Bits
*/

function sortByBits(arr: number[]): number[] {
    return arr.sort((a, b) => hammingWeight(a) - hammingWeight(b) || a - b);
};

function hammingWeight(n: number) {
    let count = 0;
    while (n) {
        count += n & 1;
        n = n >> 1;
    }
    return count;
};