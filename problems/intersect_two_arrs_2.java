/*
 * 350. Intersection of Two Arrays II
 */

public class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> chars_to_map = new HashMap<Integer, Integer>();
    ArrayList<Integer> arr_intersect = new ArrayList<Integer>();
    for (int i = 0; i < nums1.length; i++) {
      if (!chars_to_map.containsKey(nums1[i])) {
        chars_to_map.put(nums1[i], 1);
      } else {
        chars_to_map.put(nums1[i], chars_to_map.get(nums1[i]) + 1);
      }
    }
    for (int j = 0; j < nums2.length; j++) {
      if (
        chars_to_map.containsKey(nums2[j]) && chars_to_map.get(nums2[j]) != 0
      ) {
        arr_intersect.add(nums2[j]);
        chars_to_map.put(nums2[j], chars_to_map.get(nums2[j]) - 1);
      }
    }
    return arr_intersect.stream().mapToInt(n -> n).toArray();
  }
}
