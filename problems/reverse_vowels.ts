/*
* 345. Reverse Vowels of a String
*/


function reverseVowels(s: string): string {

    const isVowel = (str: string) => {
        str = str.toLowerCase();
        return str == "a" || str == "e" || str == "i" || str == "o" || str == "u"
    }

    let begin: number = 0;
    let end: number = s.length - 1;
    const str: string[] = [...s];

    while (begin < end) {
        while (begin < str.length && !isVowel(str[begin])) {
            begin++;
        }
        while (end >= 0 && !isVowel(str[end])) {
            end--;
        }
        if (begin < end) {
            [str[begin], str[end]] = [str[end], str[begin]]
            begin++;
            end--;
        }
    }
    return str.join("");
};