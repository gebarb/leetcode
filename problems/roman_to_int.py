"""LeetCode 13. Roman to Integer"""


class Solution:

    numerals = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000,
    }

    def romanToInt(self, s: str) -> int:
        ttl = 0
        for i in range(0, len(s)):
            curr = self.numerals[s[i]]
            if (i+1 < len(s)):
                next = self.numerals[s[i+1]]
                if curr >= next:
                    ttl += curr
                elif curr < next:
                    ttl -= curr
            else:
                ttl += curr
        return ttl
