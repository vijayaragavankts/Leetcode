class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int noCircular = f(nums);
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        int circular = f(nums);
        int res = totalSum + circular;
        if(res == 0){
            return noCircular;
        }
        return Math.max(res,noCircular);
    }
    public int f(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int val:nums){
            sum += val;
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}