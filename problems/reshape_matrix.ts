/*
* 566. Reshape the Matrix
*/

function matrixReshape(mat: number[][], r: number, c: number): number[][] {

    if ((mat.length * mat[0].length) != (r * c)) {
        return mat;
    }
    let ret: number[][] = [...Array(r)].map(e => Array(c).fill(0));;
    let k: number, l: number;
    k = l = 0;
    for (let i: number = 0; i < r; i++) {
        for (let j: number = 0; j < c; j++) {
            ret[i][j] = mat[k][l];
            if (l == mat[0].length - 1) {
                k++;
            }
            l++;
            l %= mat[0].length
        }
    }
    return ret;
};