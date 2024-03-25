/*
 * 338. Counting Bits
 */

function countBits(n: number): number[] {
  const count = new Uint8Array(n + 1);
  for (let i = 0; i < count.length; i++) {
    count[i] = count[i >> 1] + (i & 1);
  }
  return [...count];
}
