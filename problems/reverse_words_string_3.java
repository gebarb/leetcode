/*
 * 557. Reverse Words in a String III
 */

class Solution {

  public String reverseWords(String s) {
    int space_idx = -1;
    char[] words = s.toCharArray();
    int len = s.length();
    for (int i = 0; i <= len; i++) {
      if (i == len || words[i] == ' ') {
        int begin = space_idx + 1;
        int end = i - 1;
        while (begin < end) {
          char swap = words[begin];
          words[begin] = words[end];
          words[end] = swap;
          begin++;
          end--;
        }
        space_idx = i;
      }
    }
    return new String(words);
  }
}
