/*
* 1588. Sum of All Odd Length Subarrays
*/

function sumOddLengthSubarrays(arr: number[]): number {
    // Since we are only concerned with the Sum, and not maintaining elements or history
    // --> Only need to know how many times each integer in `arr` appears in an odd-length subarray
    let sum: number = 0;

    // Given arr[i]:
    // -> There are (i + 1) such subarrays to the left where ((i + 1) / 2) of them have odd-length and the rest have even-length
    // -> There are (n - 1 - i) such subarrays to the right where ((n - i) / 2) of them have odd-length and the rest have even-length
    for (let i: number = 0; i < arr.length; i++) {
        let [left, right]: number[] = [i, arr.length - i - 1];
        sum += arr[i] * Math.floor(left / 2 + 1) * Math.floor(right / 2 + 1);
        sum += arr[i] * Math.floor((left + 1) / 2) * Math.floor((right + 1) / 2);
    }

    return sum;
};