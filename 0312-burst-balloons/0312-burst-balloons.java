class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        int x = 1;
        for(int i=0;i<n;i++){
            arr[x++] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        return f(1,n,arr,dp);
    }
    public int f(int i, int j, int[] nums, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int max = 0;
        for(int k=i;k<=j;k++){
            int ans =( nums[i-1] * nums[k] * nums[j+1] ) + f(i,k-1,nums,dp) + f(k+1,j,nums,dp);
            max = Math.max(max,ans);
        }
        dp[i][j] = max;
        return max;
    }
}