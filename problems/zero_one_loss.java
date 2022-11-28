/*
 * 2225. Find Players With Zero or One Losses
 */

class Solution {

  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> player_record_map = new HashMap<>();
    for (int[] match : matches) {
      int winner = match[0];
      int loser = match[1];
      player_record_map.put(winner, player_record_map.getOrDefault(winner, 0));
      player_record_map.put(
        loser,
        (player_record_map.getOrDefault(loser, 0) + 1)
      );
    }

    List<List<Integer>> near_perfect_records = Arrays.asList(
      new ArrayList<>(),
      new ArrayList<>()
    );
    for (Integer player : player_record_map.keySet()) {
      // 0 Loss
      if (player_record_map.get(player) == 0) {
        near_perfect_records.get(0).add(player);
      }
      // 1 Loss
      else if (player_record_map.get(player) == 1) {
        near_perfect_records.get(1).add(player);
      }
    }

    // Sort Increasing Order
    Collections.sort(near_perfect_records.get(0));
    Collections.sort(near_perfect_records.get(1));

    return near_perfect_records;
  }
}
