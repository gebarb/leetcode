/*
 * 953. Verifying an Alien Dictionary
 */

class Solution {

  public boolean isAlienSorted(String[] words, String order) {
    int[] lex = new int[26];
    for (int i = 0; i < order.length(); i++) {
      lex[order.charAt(i) - 'a'] = i;
    }

    for (int j = 0; j < words.length - 1; j++) {
      for (int k = 0; k < words[j].length(); k++) {
        // If we do not find a mismatch letter between words[j] and words[j + 1],
        // we need to examine the case when words are like ("apple", "app").
        if (k >= words[j + 1].length()) {
          return false;
        }
        if (words[j].charAt(k) != words[j + 1].charAt(k)) {
          int curr_word_char = words[j].charAt(k) - 'a';
          int next_word_char = words[j + 1].charAt(k) - 'a';
          if (lex[curr_word_char] > lex[next_word_char]) {
            return false;
          } else {
            break;
          }
        }
      }
    }

    return true;
  }
}
