/*
 * 1309. Decrypt String from Alphabet to Integer Mapping
 */

class Solution {

  public String freqAlphabets(String s) {
    // Assume string is well-formed
    StringBuilder result = new StringBuilder();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      // Characters ('j' to 'z') are represented by ('10#' to '26#') respectively
      if ((i + 2) < chars.length && chars[i + 2] == '#') {
        result.append(
          (char) ('j' + (chars[i] - '1') * 10 + chars[i + 1] - '0')
        );
        i += 2;
      }
      // Characters ('a' to 'i') are represented by ('1' to '9') respectively
      else {
        result.append((char) ('a' + (chars[i] - '1')));
      }
    }
    return result.toString();
  }
}
