class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return f(n,dp);
    }
    public int f(int n, int[] dp){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = f(n-1,dp) + f(n-2,dp);
        return dp[n];
    }
}