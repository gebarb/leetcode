"""12. Integer to Roman"""

import math


class Solution:

    numerals = {
        1: "I",
        5: "V",
        10: "X",
        50: "L",
        100: "C",
        500: "D",
        1000: "M",
    }

    def intToRoman(self, num: int) -> str:
        place_val = 1
        ret = ""
        while num >= place_val:
            place_val *= 10

        place_val //= 10

        while num:

            last_num = (num // place_val)

            # Deal with special prefix situations
            if last_num <= 3:
                ret += (self.numerals[place_val] * last_num)
            elif last_num == 4:
                ret += (self.numerals[place_val] +
                        self.numerals[place_val * 5])
            elif 5 <= last_num <= 8:
                ret += (self.numerals[place_val * 5] +
                        (self.numerals[place_val] * (last_num - 5)))
            elif last_num == 9:
                ret += (self.numerals[place_val] +
                        self.numerals[place_val * 10])

            num = math.floor(num % place_val)
            place_val //= 10
        return ret
