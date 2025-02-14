"""
66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
"""

from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # Naive approach - convert to integer, increment, convert back
        # n = int(''.join(map(str, digits))) + 1
        # return list(map(int, str(n)))

        # Better approach
        # Tterate digits in reverse
        for i in range(len(digits) - 1, -1, -1):
            # Handle carry-over
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] = digits[i] + 1
                # Only incrementing by 1, so finished the first time
                return digits

        # If all digits are 9, add a new digit to the beginning for carry-over
        return [1] + digits
