/*
* 1572. Matrix Diagonal Sum
*/

function diagonalSum(mat: number[][]): number {
    let n: number = mat.length;
    let sum: number = 0;

    for (let i: number = 0; (2 * i) < n; i++) {
        // Primary Diagonal: Row == Column
        sum += mat[i][i];
        // Secondary Diagonal: Row == Length - Column - 1
        sum += mat[i][n - i - 1];
    }

    // Avoid double-counting the Center Element
    return (n % 2 == 0) ? sum : sum - mat[Math.floor(n / 2)][Math.floor(n / 2)];
};