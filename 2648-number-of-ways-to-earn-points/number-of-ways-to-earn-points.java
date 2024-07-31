class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1000000007;
        int n = types.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int count = types[i - 1][0];
            int mark = types[i - 1][1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // Not taking any questions of this type
                for (int k = 1; k <= count && k * mark <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * mark]) % mod;
                }
            }
        }

        return dp[n][target];
    }
}