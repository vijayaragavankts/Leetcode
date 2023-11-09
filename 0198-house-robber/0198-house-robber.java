class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            if(i == 0){
                dp[i] = nums[i];
            }
            int take = nums[i];
            int notTake = 0;
            if(i > 0){
                notTake = dp[i-1];
            }
            if(i > 1){
                take += dp[i-2];
            }
            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
    }
}