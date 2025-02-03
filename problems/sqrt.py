"""69. Sqrt(x)"""


class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x

        minimum, maximum = 0, x // 2

        while minimum <= maximum:
            mid = minimum + (maximum - minimum) // 2
            sq = mid * mid
            if sq == x:
                return mid
            elif sq < x:
                minimum = mid + 1
            else:
                maximum = mid - 1

        return maximum
