/*
 * 394. Decode String
 */

import java.util.*;

public class Solution {

  public String decodeString(String s) {
    Vector<Character> char_stack = new Vector<Character>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ']') {
        String tmp = "";
        while (
          char_stack.size() > 0 && char_stack.get(char_stack.size() - 1) != '['
        ) {
          tmp = char_stack.get(char_stack.size() - 1) + tmp;
          char_stack.remove(char_stack.size() - 1);
        }

        char_stack.remove(char_stack.size() - 1);
        String num = "";

        while (
          char_stack.size() > 0 &&
          char_stack.get(char_stack.size() - 1) >= 48 &&
          char_stack.get(char_stack.size() - 1) <= 57
        ) {
          num = char_stack.get(char_stack.size() - 1) + num;
          char_stack.remove(char_stack.size() - 1);
        }

        int number = Integer.parseInt(num);
        String repeat = "";
        for (int j = 0; j < number; j++) {
          repeat += tmp;
        }

        for (int c = 0; c < repeat.length(); c++) {
          char_stack.add(repeat.charAt(c));
        }
      } else {
        char_stack.add(s.charAt(i));
      }
    }
    String decoded = "";
    while (char_stack.size() > 0) {
      decoded = char_stack.get(char_stack.size() - 1) + decoded;
      char_stack.remove(char_stack.size() - 1);
    }
    return decoded;
  }
}
