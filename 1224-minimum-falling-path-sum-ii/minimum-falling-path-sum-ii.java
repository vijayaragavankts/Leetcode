class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        // for 1st row , try out all possibilities
        for(int i=0;i<n;i++){
            res = Math.min(res,f(grid,0,i,dp));
        }
        return res;
    }
    public int f(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        if(i >= n || j < 0 || j >= n){
            return Integer.MAX_VALUE;
        }
        if(i == n-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        // for the next row, try out all the possibilities ,except currect col
        for(int x=0;x<n;x++){
            if(j != x){
                res = Math.min(res,f(grid,i+1,x,dp));
            }
        }
        return dp[i][j] = res + grid[i][j];
    }
}