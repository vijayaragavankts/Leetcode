class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        int l = 0;
        int r = n-1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                res[0] = l+1;
                res[1] = r+1;
                break;
            }
            if(sum < target){
                l++;
            }
            if(sum > target){
                r--;
            }
        }
        return res;
    }
}