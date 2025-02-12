/*
 * 151. Reverse Words in a String
 */

function reverseWords(s: string): string {
  //   let reverse: string[] = [];
  //   let word: string = "";

  //   s = s.trim();
  //   for (let i = s.length - 1; i >= 0; i--) {
  //     word = s[i] + word;
  //     if (s[i] === " " || i === 0) {
  //       if (word !== " ") {
  //         reverse.push(word.trim());
  //       }
  //       word = "";
  //     }
  //   }
  //   return reverse.join(" ");

  return s.split(" ").reduce((reverse, char, index) => {
    return char === ""
      ? reverse
      : index === 0 || reverse === ""
      ? char
      : `${char} ${reverse}`;
  }, "");
}
