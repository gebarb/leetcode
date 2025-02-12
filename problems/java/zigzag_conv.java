/*
 * 6. Zigzag Conversion
 */
class Solution {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, s.length()); i++) {
      rows.add(new StringBuilder());
    }

    int curr_row = 0;
    // down is false, up is true
    boolean direction = false;

    for (char c : s.toCharArray()) {
      rows.get(curr_row).append(c);
      if (curr_row == 0 || curr_row == numRows - 1) {
        direction = !direction;
      }
      curr_row += direction ? 1 : -1;
    }

    StringBuilder zigzag = new StringBuilder();
    for (StringBuilder row : rows) {
      zigzag.append(row);
    }
    return zigzag.toString();
  }
}
