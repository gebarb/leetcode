/*
* 123. Best Time to Buy and Sell Stock III
*/

function maxProfit(prices: number[]): number {
    let invest_one: number = Math.max(), invest_two: number = Math.max();
    let return_one: number = 0, return_two: number = 0;
    for (let i = 0; i < prices.length; i++) {
        invest_one = Math.max(invest_one, -prices[i]);
        return_one = Math.max(return_one, invest_one + prices[i]);
        invest_two = Math.max(invest_two, return_one - prices[i]);
        return_two = Math.max(return_two, invest_two + prices[i]);
    }
    return return_two;
};