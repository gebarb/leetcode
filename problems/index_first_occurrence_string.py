"""28. Find the Index of the First Occurrence in a String"""


class Solution:

    def strStr(self, haystack: str, needle: str) -> int:
        l = len(needle)
        for i in range(len(haystack)):
            if haystack[i:i + l] == needle:
                return i

        return -1
