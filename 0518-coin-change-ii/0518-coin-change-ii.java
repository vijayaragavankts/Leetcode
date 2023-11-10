class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int res = f(n-1,amount,coins,dp);
        int ans = res == 0 ? 0 : res;
        return res;
    }
    public int f(int i, int target, int[] nums, int[][] dp){
        if(i < 0){
            return 0;
        }
        if(i == 0){
            if(target % nums[i] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        int take = 0;
        int notTake = f(i-1,target, nums,dp);
        if(nums[i] <= target){
            take =  f(i,target-nums[i],nums,dp);
        }
        return dp[i][target] = take + notTake;
    }
}