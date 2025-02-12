/*
 * 1431. Kids With the Greatest Number of Candies
 */

function kidsWithCandies(candies: number[], extraCandies: number): boolean[] {
  const max: number = candies.reduce((max, c) => {
    return Math.max(max, c);
  }, 0);

  let greatest: boolean[] = [];
  for (const kid of candies) {
    greatest.push(kid + extraCandies >= max);
  }
  return greatest;
}
