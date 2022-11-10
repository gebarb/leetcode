/*
 * 1047. Remove All Adjacent Duplicates In String
 */
class Solution {

  public String removeDuplicates(String s) {
    Stack<Character> char_stack = new Stack<Character>();

    // Store the index of str
    int i = 0;

    // Traverse the String str
    while (i < s.length()) {
      // If top of the stack is not equal to current character
      if (char_stack.isEmpty() || s.charAt(i) != char_stack.peek()) {
        char_stack.add(s.charAt(i));
        i++;
      }
      // If top element of the stack is equal to the current character
      else {
        char_stack.pop();
        i++;
      }
    }
    String s_prime = "";
    while (!char_stack.isEmpty()) {
      s_prime = char_stack.peek() + s_prime;
      char_stack.pop();
    }
    return (s_prime);
  }
}
