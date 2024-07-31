class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val:nums){
            sum += val;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][50000];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(nums,n-1,target,dp);
    }
    public boolean f(int[] nums, int i, int target,int[][] dp){
        if(target == 0){
            return true;
        }
        if(i == 0){
            return nums[i] == target;
        }
        if(dp[i][target] != -1){
            return dp[i][target] == 1 ? true:false;
        }
        boolean notTake = f(nums,i-1,target,dp);
        boolean take = false;
        if(target >= nums[i]){
            take = f(nums,i-1,target-nums[i],dp);
        }
        dp[i][target] = take || notTake ? 1 : 0;
        return take || notTake;

    }
}