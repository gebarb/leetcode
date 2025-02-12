/*
* 344. Reverse String
*/


/**
 Do not return anything, modify s in-place instead.
 */
function reverseString(s: string[]): void {

    let begin: number = 0;
    let end: number = s.length - 1;

    while (begin < end) {
        [s[begin], s[end]] = [s[end], s[begin]]
        begin++;
        end--;
    }
    return;
};