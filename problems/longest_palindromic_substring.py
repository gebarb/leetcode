"""5. Longest Palindromic Substring"""


class Solution:

    def expand(s, low, high):
        length = len(s)
        # Check to see if character in either direction from Center is the same
        while low >= 0 and high < length and s[low] == s[high]:
            # Then it can be part of our palindrome
            low = low - 1
            high = high + 1
        return s[low + 1:high]

    def longestPalindrome(self, s: str) -> str:

        if not s or not len(s):
            return ""
        elif len(s) == 1:
            return s
        else:
            palindrome = ""
            length = 0
            for i in range(len(s)):
                center = Solution.expand(s, i, i)
                curr = len(center)
                if curr > length:
                    length = curr
                    palindrome = center
                center = Solution.expand(s, i, i + 1)
                curr = len(center)
                if curr > length:
                    length = curr
                    palindrome = center
            return palindrome
