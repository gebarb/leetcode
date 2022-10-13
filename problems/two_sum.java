/*
 * 1. Two Sum
 */

class Solution {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null) {
      return null;
    }

    if (nums.length == 0) {
      return new int[0];
    }

    Map<Integer, Integer> hash = new HashMap<>();
    hash.put(nums[0], 0);

    for (int i = 1; i < nums.length; i++) {
      int complement = target - nums[i];
      Integer index = hash.get(complement);

      if (index != null) {
        return new int[] { index, i };
      }

      hash.put(nums[i], i);
    }

    return null;
  }
}
