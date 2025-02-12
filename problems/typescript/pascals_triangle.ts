/*
* 118. Pascal's Triangle
*/

function generate(numRows: number): number[][] {
    let ret: number[][] = [];
    let tmp: number[];
    for (let i: number = 0; i < numRows; i++) {
        tmp = [1];
        if (i == 0) {
            ret.push([1]);
            continue;
        }
        else if (i > 0) {
            let prev_row = ret[i - 1];
            for (let j = 1; j < i; j++) {
                tmp.push(prev_row[j - 1] + prev_row[j])
            }
        }
        tmp.push(1)
        ret.push(tmp);
    }
    return ret;
};
