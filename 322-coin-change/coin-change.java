class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int val = f(coins,n-1,amount,dp);
        return val == (int)1e9 ? -1 : val;
    }
    public int f(int[] nums, int i, int target, int[][] dp){
        if(i < 0){
            return (int)1e9;
        }
        if(i == 0){
            if(target % nums[i] == 0){
                return target / nums[i];
            }
            return (int)1e9;
        }
        if(dp[i][target] != 0){
            return dp[i][target];
        }
        int notTake = 0 + f(nums, i-1,target,dp);
        int take = (int)1e9;
        if(target >= nums[i]){
            take = 1 + f(nums,i,target-nums[i],dp);
        }
        return dp[i][target] = Math.min(take,notTake);
    }
}