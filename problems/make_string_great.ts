/*
* 1544. Make The String Great
*/

function makeGood(s: string): string {
    while (s.length > 1) {
        // Keep track of whether we need to reprocess an altered string
        let recheck: boolean = false;
        for (let i = 0; i < s.length - 1; i++) {
            // Given constraint of: s contains only lower and upper case English letters
            // --> can compare letter casing via ASCII values
            if (Math.abs(s.charCodeAt(i) - s.charCodeAt(i + 1)) == 32) {
                s = s.slice(0, i) + s.slice(i + 2);
                recheck = true;
                break;
            }
        }

        if (!recheck) {
            break;
        }
    }
    return s;
};