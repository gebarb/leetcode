"""
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Constraints:

0 <= n <= 10^4
"""


class Solution:
    def trailingZeroes(self, n: int) -> int:
        trailing = 0
        while n > 0:
            # Trailing 0s are caused by factors of 10 = 2 * 5
            # Will always have more factors of 2 than 5, so only keep track of 5
            n //= 5
            trailing += n

        return trailing
