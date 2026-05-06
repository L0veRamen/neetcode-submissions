class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];
        for (int p : prices) {
            res = Math.max(res, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return res;

    }
}
