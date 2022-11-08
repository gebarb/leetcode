/*
* 1323. Maximum 69 Number
*/

function maximum69Number(num: number): number {
    let str: string[] = [...String(num)];
    for (let i = 0; i < str.length; i++) {
        if (str[i] == "6") {
            str[i] = "9";
            break;
        }
    }

    return Number(str.join(""));
};