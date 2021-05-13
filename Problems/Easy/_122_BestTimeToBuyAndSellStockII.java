/** 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 */

package Problems.Easy;

public class _122_BestTimeToBuyAndSellStockII {
    /**
     * Finds the max profit achieved by buying and selling stocks given an array of daily stock 
     * prices.
     * @param prices Array of daily stock prices. 1 <= prices.length <= 3 * 10^4. 
     * 0 <= prices[i] <= 10^4.
     * @return Max profit possible as an integer.
     */
    public int maxProfit(int[] prices) {
        boolean boughtStock = false;
        int profit = 0, buyPrice = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1] && boughtStock) {
                // Sell if prices start to downtrend and we have stock to sell
                
                profit += (prices[i - 1] - buyPrice);
                boughtStock = false;
            } else if (prices[i] > prices[i - 1] && boughtStock == false) {
                // Buy if prices start to uptrend and we don't have stock
                
                buyPrice = prices[i - 1];
                boughtStock = true;
            }
        }
        
        // Handle scenario if prices array ends on an upward trend
        if (boughtStock) {
            profit += (prices[prices.length - 1] - buyPrice);
        }
        
        return profit;
    }
}
