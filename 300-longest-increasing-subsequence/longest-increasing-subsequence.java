class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(nums,0,-1,n);
    }
    public int f(int[] nums, int i, int prev, int n){
        // base case
        if(i == n){
            return 0;
        }

        if(dp[i+1][prev+1] != -1){
            return dp[i+1][prev+1];
        }

        int notTake = f(nums,i+1,prev,n);
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + f(nums,i+1,i,n);
        }
        return dp[i+1][prev+1] = Math.max(take,notTake);
    }
}