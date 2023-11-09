class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int x = 0;
        int a = 0;
        int b = 0;
        // edge case
        if(n == 1){
            return nums[0];
        }
        for(int i=0;i<n;i++){
            if(i > 0){
                arr2[a++] = nums[i];
            }
            if(i < n-1){
                arr1[b++] = nums[i];
            }
        }
        int res1 = f(arr1);
        int res2 = f(arr2);
        return Math.max(res1,res2);
    }
    public int f(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i == 0){
                dp[i] = nums[i];
            }
            else{
                int notTake = dp[i-1];
                int take = nums[i];
                if(i > 1){
                    take += dp[i-2];
                }
                dp[i] = Math.max(take,notTake);
            }
        }
        return dp[n-1];
    }
}