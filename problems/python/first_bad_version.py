"""278. First Bad Version"""

# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:


class Solution:
    def firstBadVersion(self, n: int) -> int:
        begin, end = 1, n
        while begin < end:
            midpoint = begin + (end - begin) / 2
            if isBadVersion(midpoint):
                end = midpoint
            else:
                begin = midpoint + 1
        return int(begin)
