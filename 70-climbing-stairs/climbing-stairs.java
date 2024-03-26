class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return f(n,dp);
    }
    public int f(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int one = f(n-1,dp);
        int two = f(n-2,dp);
        dp[n] = one + two;
        return dp[n];
    }
}