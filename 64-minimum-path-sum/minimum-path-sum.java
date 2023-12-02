class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,(int)1e9);
        }
        return f(m-1,n-1,grid,dp);
    }
    public int f(int i, int j, int[][] grid,int[][] dp){
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(dp[i][j] != (int)1e9){
            return dp[i][j];
        }
        int left = f(i,j-1,grid,dp);
        int up = f(i-1,j,grid,dp);
        return dp[i][j] = Math.min(left,up) + grid[i][j];
    }
}