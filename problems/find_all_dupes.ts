/*
 * 442. Find All Duplicates in an Array
 */

function findDuplicates(nums: number[]): number[] {
  let answer: number[] = [];
  const numsCount = nums.reduce((duplicates, n) => {
    if (!duplicates[n]) {
      duplicates[n] = 0;
    } else if (duplicates[n] === 1) {
      answer.push(n);
    }
    duplicates[n]++;
    return duplicates;
  }, {});
  return answer;
}
