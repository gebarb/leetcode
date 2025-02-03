"""45. Jump Game II"""


from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        near = far = jumps = 0

        while far < len(nums) - 1:
            jump = max([i + nums[i] for i in range(near, far + 1)])

            near = far + 1
            far = jump
            jumps += 1

        return jumps
