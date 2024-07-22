class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        return f(nums,m-1,n-1,dp);
    }
    public int f(int[][] nums, int i, int j, int[][] dp){
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
        int top = f(nums,i-1,j,dp);
        int left = f(nums,i,j-1,dp);
        return dp[i][j] = top + left;
    }
}