/*
* 409. Longest Palindrome
*/

function longestPalindrome(s: string): number {
    let char_map: any = {};
    let max_length: number = 0;
    for (const char of s) {
        char_map[char] ? char_map[char]++ : char_map[char] = 1;
        if (char_map[char] % 2 == 0) {
            max_length += 2;
        }
    }
    if (s.length > max_length) {
        return max_length + 1;
    }
    else {
        return max_length;
    }
};