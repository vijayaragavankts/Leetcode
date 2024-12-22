class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        int l = 0;
        int r = 2;
        while(r < n){
            if(nums[l] + nums[r] == (nums[l+1]/2.0)){
                res++;
            }
            r++;
            l++;
        }
        return res;
    }
}