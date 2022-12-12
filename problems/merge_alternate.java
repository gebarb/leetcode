/*
 * 1768. Merge Strings Alternately
 */

class Solution {

  public String mergeAlternately(String word1, String word2) {
    StringBuilder word = new StringBuilder();
    int i = 0;
    int j = 0;

    while (i < word1.length() || j < word2.length()) {
      if (i < word1.length()) {
        word.append(word1.charAt(i));
        i++;
      }
      if (j < word2.length()) {
        word.append(word2.charAt(j));
        j++;
      }
    }
    return word.toString();
  }
}
