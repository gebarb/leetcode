/*
 * 567. Permutation in String
 */

public class Solution {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    HashMap<Character, Integer> perm_char_map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) perm_char_map.put(
      s1.charAt(i),
      perm_char_map.getOrDefault(s1.charAt(i), 0) + 1
    );

    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      HashMap<Character, Integer> char_map = new HashMap<>();
      for (int j = 0; j < s1.length(); j++) {
        char_map.put(
          s2.charAt(i + j),
          char_map.getOrDefault(s2.charAt(i + j), 0) + 1
        );
      }
      if (matches(perm_char_map, char_map)) {
        return true;
      }
    }
    return false;
  }

  public boolean matches(
    HashMap<Character, Integer> perm_char_map,
    HashMap<Character, Integer> char_map
  ) {
    for (char key : perm_char_map.keySet()) {
      if (perm_char_map.get(key) - char_map.getOrDefault(key, -1) != 0) {
        return false;
      }
    }
    return true;
  }
}
