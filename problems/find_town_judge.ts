/*
 * 997. Find the Town Judge
 */

function findJudge(n: number, trust: number[][]): number {
  // Treat trust as a Directed Graph
  // --> Node such that (degree_in - degree_out) == (n - 1) would be the Judge
  let trust_count: number[] = Array(n + 1).fill(0);
  for (const t of trust) {
    trust_count[t[0]]--;
    trust_count[t[1]]++;
  }
  return trust_count.indexOf(n - 1) || 1;
};

