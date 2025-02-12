/*
 * 198. House Robber
 */

class Solution {

  public int rob(int[] nums) {
    int money_if_robbed = 0;
    int money_if_skipped = 0;
    for (int i = 0; i < nums.length; i++) {
      int loot = money_if_skipped + nums[i];
      // If skipped robbing ith house
      // take the max value of robbed (i-1)th house and skip robbing (i-1)th house
      money_if_skipped = Math.max(money_if_skipped, money_if_robbed);
      money_if_robbed = loot;
    }
    return Math.max(money_if_robbed, money_if_skipped);
  }
}
