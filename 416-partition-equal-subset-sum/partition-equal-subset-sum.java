class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int val:nums){
            total += val;
        }
        if(total % 2 != 0){
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n][(total/2)+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(nums,n-1,total/2,dp);
    }
    public boolean f(int[] nums, int ind, int target,int[][] dp){
        if(ind == 0){
            return target == nums[ind];
        }
        if(target == 0){
            return true;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target] == 1 ? true : false;
        }
        boolean notTake = f(nums,ind-1,target,dp);
        boolean take = false;
        if(target >= nums[ind]){
            take = f(nums,ind-1,target-nums[ind],dp);
        }
        dp[ind][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}