/*
* 122. Best Time to Buy and Sell Stock II
*/

function maxProfit(prices: number[]): number {
    let max = 0;
    for (let i = 1; i < prices.length; i++) {
        let profit = prices[i] - prices[i - 1];
        if (profit > 0) {
            max += profit;
        }
    }
    return max;
};