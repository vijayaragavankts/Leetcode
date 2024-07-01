class Solution {
    public int maxSubArray(int[] nums) {
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