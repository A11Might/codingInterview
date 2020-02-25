/**
 * [63] 股票的最大利润
 *
 * 题目: 假设把某股票的价格按照时间先后顺序存储在数组中, 返回买卖该股票一次可能获得的最大利润.
 *
 * 思路: 贪心策略, 假设第 i 天进行卖出操作, 买入操作应该在第 i 天之前并且买入价格为目前为止的最低价格.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // the lowest price so far.
            soFarMin = Math.min(soFarMin, prices[i]);
            // the maximum profit can be make so far.
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}