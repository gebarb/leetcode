"""14. Longest Common Prefix"""

from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # Assume first string is possible prefix
        prefix = strs[0]
        l = len(prefix)

        # Compare to each subsequent string
        # Determine if first contains or comprises prefix
        for s in strs[1:]:
            while prefix != s[0:l]:
                l -= 1
                if l == 0:
                    return ""
                prefix = prefix[0:l]

        return prefix
