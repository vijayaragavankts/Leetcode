class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int l = 0;
        int r = n-1;
        while(l <= r){
            int sum = nums[l] + nums[r];
            res = Math.max(res,sum);
            r--;
            l++;
        }
        return res;
    }
}