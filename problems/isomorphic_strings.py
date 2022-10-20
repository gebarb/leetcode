"""205. Isomorphic Strings"""


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        else:
            char_map = {}
            used_chars = set()
            for i in range(len(s)):
                char_s = s[i]
                char_t = t[i]

                if char_s in char_map:
                    if char_map[char_s] != char_t:
                        return False
                else:
                    if char_t in used_chars:
                        return False
                    else:
                        char_map[char_s] = char_t
                        used_chars.add(char_t)
            return True
