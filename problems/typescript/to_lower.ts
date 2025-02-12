/*
* 709. To Lower Case
*/

function toLowerCase(s: string): string {
    let lower = [...s];
    // If character is Upper Case, add 32 to ASCII value to match Case-Offset
    // Otherwise, no change
    lower = lower.map(c => /[A-Z]/.test(c) ? String.fromCharCode(c.charCodeAt(0) + 32) : c)
    return lower.join("");
};