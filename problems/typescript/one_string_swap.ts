/*
* 1790. Check if One String Swap Can Make Strings Equal
*/

function areAlmostEqual(s1: string, s2: string): boolean {
    // Since only performing a single Swap Op
    // --> Strings must match char-by-char
    // --> OR char-by-char has 2 mismatches with swapped chars
    let mismatches: number = 0;
    let first: number = 0;
    let second: number = 0;
    for (let i: number = 0; i < s1.length; i++)
        if (s1[i] != s2[i]) {
            mismatches++;
            if (!first) {
                first = i;
            }
            else {
                second = i;
            }
        }
    return (mismatches == 0 || mismatches == 2) && (s1[first] == s2[second]) && (s1[second] == s2[first]);
};