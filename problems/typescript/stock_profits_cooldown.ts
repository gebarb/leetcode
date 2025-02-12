/*
* 309. Best Time to Buy and Sell Stock with Cooldown
*/

function maxProfit(prices: number[]): number {

    let invest: number[] = new Array(prices.length).fill(Math.max());
    let trade: number[] = new Array(prices.length).fill(0);

    for (let i = 0; i < prices.length; i++) {
        invest[i] = Math.max(
            ((i > 0) ? invest[i - 1] : -prices[0]),
            ((i > 1) ? trade[i - 2] : 0) - prices[i]
        );
        trade[i] = Math.max(
            ((i > 0) ? trade[i - 1] : 0),
            ((i > 0) ? invest[i - 1] : -prices[0]) + prices[i]
        );
    }
    return trade[trade.length - 1];
};