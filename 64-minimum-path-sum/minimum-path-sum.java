class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return f(grid,m-1,n-1,dp);
    }
    public int f(int[][] grid, int i, int j,int[][] dp){
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int top =  f(grid,i-1,j,dp);
        int left =  f(grid,i,j-1,dp);
        return dp[i][j] = Math.min(top,left) + grid[i][j];
    }
}