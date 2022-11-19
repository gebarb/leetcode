/*
 * 784. Letter Case Permutation
 */

class Solution {

  void permute(char[] str, int idx, List<String> perms) {
    // If leaf in recursion tree, save perms
    if (idx == str.length) {
      perms.add(new String(str));
      return;
    }

    // If char is a letter
    if (Character.isLetter(str[idx])) {
      // If uppercase char, make it lowercase
      if (Character.isUpperCase(str[idx])) {
        str[idx] = Character.toLowerCase(str[idx]);

        // Recurse branches w/ change
        permute(str, idx + 1, perms);

        //Backtracking - Undo change to start a new branch in recursion tree.
        str[idx] = Character.toUpperCase(str[idx]);
      }
      // If lowercase, then make it uppercase
      else {
        str[idx] = Character.toUpperCase(str[idx]);
        permute(str, idx + 1, perms);
        //Backtracking - Undo change to start a new branch in recursion tree.
        str[idx] = Character.toLowerCase(str[idx]);
      }
    }
    // Recurse branches as is
    permute(str, idx + 1, perms);
  }

  public List<String> letterCasePermutation(String s) {
    List<String> permutations = new ArrayList<>();
    permute(s.toCharArray(), 0, permutations);
    return permutations;
  }
}
