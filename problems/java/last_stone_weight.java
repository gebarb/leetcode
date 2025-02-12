/*
 * 1046. Last Stone Weight
 */

// use PriorityQueue to find top two weights
class Solution {

  public int lastStoneWeight(int[] stones) {
    // Within Game, maintain sorting of stone weight
    PriorityQueue<Integer> game = new PriorityQueue<>((stone_x, stone_y) ->
      stone_y - stone_x
    );
    for (int i = 0; i < stones.length; i++) {
      game.offer(stones[i]);
    }

    while (game.size() > 1) {
      int stone_x = game.poll();
      int stone_y = game.poll();
      if (stone_x - stone_y > 0) {
        game.offer(stone_x - stone_y);
      }
    }

    return game.isEmpty() ? 0 : game.peek();
  }
}
