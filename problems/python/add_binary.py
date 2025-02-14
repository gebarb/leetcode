"""
67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
"""


class Solution:

    def addBinary(self, a: str, b: str) -> str:
        # "Cheat" with casting
        # return bin(int(a, 2) + int(b, 2))[2:]

        # Iterate each binary string in reverse
        result = ""
        carry = 0

        # Use while with counters to only loop for the longest number
        i, j = len(a) - 1, len(b) - 1
        while i >= 0 or j >= 0 or carry:
            if i >= 0:
                carry += int(a[i])
                i -= 1
            if j >= 0:
                carry += int(b[j])
                j -= 1

            result = str(carry % 2) + result
            carry //= 2

        return result
