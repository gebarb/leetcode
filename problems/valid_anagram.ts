/*
* 242. Valid Anagram
*/

function isAnagram(s: string, t: string): boolean {
    // Check if length of both strings is same or not
    if (s.length != t.length) {
        return false;
    }
    else {

        let char_map: any = {};
        for (let i: number = 0; i < s.length; i++) {
            char_map[s[i]] ? char_map[s[i]]++ : char_map[s[i]] = 1;
        }
        for (let j: number = 0; j < t.length; j++) {
            if (char_map[t[j]]) {
                char_map[t[j]]--;
            }
            else {
                return false;
            }
        }
        return true;
    }
};