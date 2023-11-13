class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return f(n-1,target,nums);
    }
    public int f(int i, int target, int[] nums){
        if(i == 0){
            if(nums[i] == 0 && target == 0){
                return 2;
            }
            if(nums[i] == Math.abs(target)){
                return 1;
            }
            return 0;
        }
        int plus = f(i-1,target+nums[i],nums);
        int minus = f(i-1,target-nums[i],nums);
        return plus + minus;
    }
}