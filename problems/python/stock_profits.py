"""121. Best Time to Buy and Sell Stock"""

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        sell = 0
        buy = prices[0]

        for p in prices:
            profit = p - buy
            if profit > sell:
                sell = profit
            if p < buy:
                buy = p

        return sell
