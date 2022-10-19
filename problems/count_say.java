/*
 * 38. Count and Say
 */

class Solution {

  public String countAndSay(int n) {
    if (n < 0) return null; else if (n == 2) return "11"; else if (
      n == 1
    ) return "1"; else {
      String ret = "11";
      for (int i = 2; i < n; i++) {
        String tmp = "";
        int cnt = 1;
        for (int j = 1; j < ret.length(); j++) {
          if (ret.charAt(j - 1) == ret.charAt(j)) {
            cnt++;
          } else {
            tmp += cnt;
            tmp += ret.charAt(j - 1);
            cnt = 1;
          }
        }
        tmp += cnt;
        tmp += ret.charAt(ret.length() - 1);
        ret = tmp;
      }
      return ret.toString();
    }
  }
}
