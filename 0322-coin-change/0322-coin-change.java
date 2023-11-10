class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int res = f(n-1,amount,coins,dp);
        int ans = res == (int)1e9 ? -1 : res;
        return ans;
    }
    public int f(int i, int target, int[] nums, int[][] dp){
        if(i < 0){
            return (int)1e9;
        }
        if(i == 0){
            if(target % nums[i] == 0){
                return target / nums[i];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[i][target] != 0){
            return dp[i][target];
        }
        int take = (int)1e9;
        int notTake = f(i-1,target, nums,dp);
        if(nums[i] <= target){
            take = 1 + f(i,target-nums[i],nums,dp);
        }
        return dp[i][target] = Math.min(take,notTake);
    }
}