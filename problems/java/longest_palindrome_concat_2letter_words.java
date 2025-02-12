class Solution {

  public int longestPalindrome(String[] words) {
    HashMap<String, Integer> word_map = new HashMap<String, Integer>();
    Integer word_count;
    for (String word : words) {
      word_count = word_map.get(word);
      if (word_count == null) {
        word_map.put(word, 1);
      } else {
        word_map.put(word, word_count + 1);
      }
    }
    String word, reversed;
    int pal_length = 0;
    boolean has_mid = false;
    for (Map.Entry<String, Integer> w : word_map.entrySet()) {
      word = w.getKey();
      word_count = w.getValue();
      // if the word is a palindrome
      if (word.charAt(0) == word.charAt(1)) {
        if (word_count % 2 == 0) {
          pal_length += word_count;
        } else {
          pal_length += word_count - 1;
          has_mid = true;
        }
        // consider a pair of non-palindrome words such that one is the reverse of another
      } else if (word.charAt(0) < word.charAt(1)) {
        reversed = "" + word.charAt(1) + word.charAt(0);
        if (word_map.containsKey(reversed)) {
          pal_length += 2 * Math.min(word_count, word_map.get(reversed));
        }
      }
    }
    if (has_mid) {
      pal_length++;
    }
    return 2 * pal_length;
  }
}
