/*
1337. The K Weakest Rows in a Matrix
*/

function kWeakestRows(mat: number[][], k: number): number[] {
    let soldiers: number[][] = mat.map((m, i) => {
        let ttl: number = m.reduce((acc, curr) => acc + curr);
        return [i, ttl];
    });
    soldiers.sort((a, b) => Number(a[1]) - Number(b[1]));
    return soldiers.slice(0, k).map((arr) => arr[0]);
};