"""125. Valid Palindrome"""

import re


class Solution:
    def isPalindrome(self, s: str) -> bool:
        # s = [c.lower() for c in s if c.isalnum()]
        # Real answer with RegEx
        s = re.sub('[^a-zA-Z0-9]', '', s).lower()

        # Compare string to reverse, much faster and pythonic
        return s == s[::-1]

        # Iterate Reversal, for practice
        # begin = 0
        # end = len(s) - 1

        # while begin < end:
        #     if s[begin] != s[end]:
        #         return False
        #     begin += 1
        #     end -= 1

        # return True
