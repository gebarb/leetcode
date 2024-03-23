/*
 * 605. Can Place Flowers
 */

function canPlaceFlowers(flowerbed: number[], n: number): boolean {
  let placedFlowers: number = 0;
  for (const [index, plot] of flowerbed.entries()) {
    if (plot === 0) {
      if (
        (index === 0 || flowerbed[index - 1] === 0) &&
        (index === flowerbed.length - 1 || flowerbed[index + 1] === 0)
      ) {
        flowerbed[index] = 1;
        placedFlowers++;
        if (placedFlowers >= n) {
          return true;
        }
      }
    }
  }
  return placedFlowers >= n;
}

canPlaceFlowers([1, 0, 0, 0, 1, 0, 0], 2);
