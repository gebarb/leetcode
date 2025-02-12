/*
 * 1678. Goal Parser Interpretation
 */

class Solution {

  public String interpret(String command) {
    // Assume command is well-formed
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < command.length(); i++) {
      // command.next == "G"
      if (command.charAt(i) == 'G') {
        result.append("G");
      }
      // command.next == "()"
      else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
        result.append("o");
        i++;
      }
      // command.next == "(al)"
      else {
        result.append("al");
        i += 3;
      }
    }
    return result.toString();
  }
}
