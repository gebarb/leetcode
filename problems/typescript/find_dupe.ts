/*
 *  287. Find the Duplicate Number
 */

function findDuplicate(nums: number[]): number {
  let answer: number = -1;
  const numsCount = nums.reduce((duplicates, n) => {
    if (!duplicates[n]) {
      duplicates[n] = 0;
    } else if (duplicates[n] === 1) {
      answer = n;
    }
    duplicates[n]++;
    return duplicates;
  }, {});
  return answer;
}
