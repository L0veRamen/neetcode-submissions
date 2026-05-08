class Solution {
    int[] prices;
    int[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.prices = prices;
        this.memo = new int[n][2];
        for (int[] row : memo) {
            Arrays.fill(row, -99999);
        }
        return dfs(n - 1, 0); // start from last day
    }

    // hold: 0 = not hold, 1 = hold
    private int dfs(int i, int hold) {
        // base case: before day 0
        if (i < 0) {
            return hold == 1 ? -99999 : 0;
        }
        // cache hit
        if (memo[i][hold] != -99999) {
            return memo[i][hold];
        }

        if (hold == 1) {
            return memo[i][hold] = Math.max(dfs(i - 1, 1), // held since before, rest
                       dfs(i - 2, 0) - prices[i]); // wasn't holding buy today
        } else {
            return memo[i][hold] = Math.max(dfs(i - 1, 0), // wasn't holding, rest
                       dfs(i - 1, 1) + prices[i]); // was holding sell today
        }
    }
}
