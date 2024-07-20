class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(nums,n-1,dp);
    }
    public int f(int[] nums, int ind, int[] dp){
        if(ind < 0){
            return 0;
        }
        if(ind == 0){
            return nums[ind];
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = nums[ind] + f(nums,ind-2,dp);
        int notPick = 0 + f(nums,ind-1,dp);
        dp[ind] = Math.max(pick,notPick);
        return dp[ind];
    }
}