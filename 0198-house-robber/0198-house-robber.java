class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
    public int f(int i, int[] nums, int[] dp){
        if(i < 0){
            return 0;
        }
        if(i == 0){
            return nums[i];
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int notTake = f(i-1,nums,dp);
        int take = nums[i];
        if(i > 1){
            take += f(i-2,nums,dp);
        }
        return dp[i] = Math.max(take,notTake);
    }
}