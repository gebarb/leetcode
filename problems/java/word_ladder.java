/*
 * 127. Word Ladder
 */

class Solution {

  public int ladderLength(
    String beginWord,
    String endWord,
    List<String> wordList
  ) {
    Set<String> words = new HashSet<>(wordList);
    if (!words.contains(endWord)) {
      return 0;
    }
    Queue<String> transform_seq = new LinkedList<>();
    transform_seq.add(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int transforms = 1;

    while (!transform_seq.isEmpty()) {
      int len = transform_seq.size();
      for (int i = 0; i < len; i++) {
        String word = transform_seq.poll();
        if (word.equals(endWord)) {
          return transforms;
        }
        for (int j = 0; j < word.length(); j++) {
          for (int k = 'a'; k <= 'z'; k++) {
            char arr[] = word.toCharArray();
            arr[j] = (char) k;

            String str = new String(arr);
            if (words.contains(str) && !visited.contains(str)) {
              transform_seq.add(str);
              visited.add(str);
            }
          }
        }
      }
      ++transforms;
    }
    return 0;
  }
}
