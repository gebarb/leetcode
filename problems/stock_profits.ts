/*
* 121. Best Time to Buy and Sell Stock
*/

function maxProfit(prices: number[]): number {
    let high: number = Math.max();
    let low: number = prices[0];
    for (let i = 0; i < prices.length; i++) {
        let profit: number = prices[i] - low;
        if (profit > high) {
            high = profit;
        }
        if (prices[i] < low) {
            low = prices[i];
        }
    }
    return high;
};