/*
* 3. Longest Substring Without Repeating Characters 
*/

function lengthOfLongestSubstring(s: string): number {
    const n: number = s.length;
    let ret: number = 0;
    for (var i: number = 0; i < n; i++) {
        let char_seen: boolean[] = new Array(26);
        for (var j = i; j < n; j++) {
            // Seen this character before?
            if (char_seen[s.charCodeAt(j)] == true)
                break;
            else {
                ret = Math.max(ret, j - i + 1);
                char_seen[s.charCodeAt(j)] = true;
            }
        }
    }
    return ret;
};