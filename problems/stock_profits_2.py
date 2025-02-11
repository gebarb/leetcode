"""122. Best Time to Buy and Sell Stock II"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        total = 0
        # With no constraint on number of sales, the maximum profit over a span
        # is equal to the sum of each individial profit over the span
        for i in range(1, len(prices)):
            profit = prices[i] - prices[i - 1]
            # Any profit will increase max total
            if profit > 0:
                total += profit

        return total
