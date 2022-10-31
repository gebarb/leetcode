"""438. Find All Anagrams in a String"""


from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ret = []
        p_char, s_char = [0]*26, [0]*26

        if len(p) > len(s):
            return ret

        for c in p:
            p_char[ord(c) - ord('a')] += 1

        for i in range(len(s) - len(p) + 1):
            if i == 0:
                for j in range(i, i + len(p)):
                    s_char[ord(s[j]) - ord('a')] += 1
            else:
                s_char[ord(s[i + len(p) - 1]) - ord('a')] += 1
            if s_char == p_char:
                ret.append(i)

            s_char[ord(s[i]) - ord('a')] -= 1

        return ret
