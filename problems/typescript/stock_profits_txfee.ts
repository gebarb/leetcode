/*
* 714. Best Time to Buy and Sell Stock with Transaction Fee
*/

function maxProfit(prices: number[], fee: number): number {

    let invest = -prices[0] - fee;
    let trade = 0;

    for (let i = 1; i < prices.length; i++) {
        let prev = invest;
        invest = Math.max(invest, trade - prices[i] - fee);
        trade = Math.max(trade, prev + prices[i]);
    }
    return trade;
};