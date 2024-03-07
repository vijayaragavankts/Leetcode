class Solution {
    public int fib(int n) {
        // memoization
        int[] dp = new int[n+1];
        return f(n,dp);
    }
    public int f(int n, int[] dp){
        if(dp[n] != 0){
            return dp[n];
        }
        if(n <= 1){
            return n;
        }
        return dp[n] = f(n-1,dp) + f(n-2,dp);
    }
}