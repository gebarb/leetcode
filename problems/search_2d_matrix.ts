/*
* 74. Search a 2D Matrix
*/

function searchMatrix(matrix: number[][], target: number): boolean {
    const m: number = matrix.length;
    const n: number = matrix[0].length;
    for (let i: number = 0; i < m; i++) {
        for (let j: number = 0; j < n; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > matrix[i][n])
                continue;
        }
    }
    return false;
};