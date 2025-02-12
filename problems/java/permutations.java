/*
 * 46. Permutations
 */

class Solution {

  private void backtrack(
    List<List<Integer>> perms,
    List<Integer> tmp,
    int[] nums
  ) {
    if (tmp.size() == nums.length) {
      perms.add(new ArrayList<>(tmp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tmp.contains(nums[i])) {
          continue;
        }
        tmp.add(nums[i]);
        backtrack(perms, tmp, nums);
        tmp.remove(tmp.size() - 1);
      }
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    backtrack(permutations, new ArrayList<>(), nums);
    return permutations;
  }
}
