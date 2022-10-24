/*
* 387. First Unique Character in a String
*/

function firstUniqChar(s: string): number {
    let char_map: any = {};
    for (let i: number = 0; i < s.length; i++) {
        char_map[s[i]] ? char_map[s[i]]++ : char_map[s[i]] = 1;
    }
    for (const char of Object.keys(char_map)) {
        if (char_map[char] === 1)
            return s.indexOf(char)
    }

    return -1;
};