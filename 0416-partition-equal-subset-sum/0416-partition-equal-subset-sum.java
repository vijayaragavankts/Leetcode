class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int val:nums){
            total += val;
        }
        if(total % 2 != 0){
            return false;
        }
        int target = total / 2;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        return f(n-1,target,nums,dp);
    }
    public boolean f(int i, int target, int[] nums, int[][] dp){
        if(i < 0){
            return false;
        }
        if(i == 0){
            return nums[i] == target;
        }
        if(dp[i][target] != 0){
            return dp[i][target] == 1 ? true : false;
        }
        boolean notTake = f(i-1,target,nums,dp);
        boolean take = false;
        if(nums[i] < target){
            take = f(i-1,target-nums[i],nums,dp);
        }
        if(take || notTake){
            dp[i][target] = 1;
        }
        else{
            dp[i][target] = -1;
        }
        return take || notTake;
    }
}