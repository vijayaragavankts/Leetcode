class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return f(m-1,n-1,dp);
    }
    public int f(int i,int j,int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int top = f(i-1,j,dp);
        int left = f(i,j-1,dp);
        return dp[i][j] = top + left;
    }
}