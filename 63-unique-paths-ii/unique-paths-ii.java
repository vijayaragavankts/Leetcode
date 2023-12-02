class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return f(m-1,n-1,obstacleGrid,dp);
    }
    public int f(int i,int j, int[][] nums, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(nums[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int left = f(i,j-1,nums,dp);
        int up = f(i-1,j,nums,dp);
        return dp[i][j] = left + up;
    }
}