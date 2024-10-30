class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        // lis from left
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp1[i] < dp1[j]+1){
                    dp1[i] = dp1[j] + 1;
                }
            }
        }
        // lis from right
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i] > nums[j] && dp2[i] < dp2[j]+1){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        System.out.print(Arrays.toString(dp1));
        System.out.print(Arrays.toString(dp2));
        int max = 0;
        for(int i=0;i<n;i++){
            if(dp1[i] != 1 && dp2[i] != 1){
                max = Math.max(max, dp1[i] + dp2[i] -1);
            }
        }
        return n-max;
    }
}