"""1672. Richest Customer Wealth"""

from typing import List


class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max_wealth = curr_wealth = 0
        for i in range(len(accounts)):
            curr_wealth = sum(accounts[i])
            if curr_wealth > max_wealth:
                max_wealth = curr_wealth
        return max_wealth
        # return max([sum(arr) for arr in accounts])
