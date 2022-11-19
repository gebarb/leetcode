/*
 * 77. Combinations
 */

public class Solution {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<List<Integer>>();
    if (k > n || k < 0) {
      return combinations;
    } else if (k == 0) {
      combinations.add(new ArrayList<Integer>());
      return combinations;
    } else {
      combinations = combine(n - 1, k - 1);
      for (List<Integer> list : combinations) {
        list.add(n);
      }
      combinations.addAll(combine(n - 1, k));
      return combinations;
    }
  }
}
