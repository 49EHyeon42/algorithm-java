class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = (price < minPrice) ? price : minPrice;
            int profit = price - minPrice;
            maxProfit = (maxProfit < profit) ? profit : maxProfit;
        }

        return maxProfit;        
    }
}
