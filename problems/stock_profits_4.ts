/*
* 124. Best Time to Buy and Sell Stock IV
*/

function maxProfit(k: number, prices: number[]): number {

    if (k < 1 || prices.length < 2) {
        return 0;
    }

    if (k > Math.floor(prices.length / 2)) {
        let profit = 0;
        for (let i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
    else {
        let invest: number[] = new Array(k).fill(Math.max());
        let trade: number[] = new Array(k).fill(0);

        for (let i = 0; i < prices.length; i++) {
            for (let j = 0; j < k; j++) {
                invest[j] = Math.max(invest[j],
                    ((j > 0) ? trade[j - 1] : 0) - prices[i]
                );
                trade[j] = Math.max(trade[j], invest[j] + prices[i]);
            }
        }
        return trade[trade.length - 1];
    }
};