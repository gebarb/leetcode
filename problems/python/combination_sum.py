"""39. Combination Sum"""

from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        l = len(candidates)
        combinations = []

        def parseCombination(index, combination, total):
            if total == target:
                combinations.append(combination[:])
                return
            if total > target or index >= l:
                return

            combination.append(candidates[index])
            parseCombination(index, combination, total + candidates[index])
            combination.pop()
            parseCombination(index + 1, combination, total)

            return combinations

        return parseCombination(0, [], 0)
