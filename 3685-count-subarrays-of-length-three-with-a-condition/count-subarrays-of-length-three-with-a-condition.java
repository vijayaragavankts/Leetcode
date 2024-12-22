class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i <= n - 3; i++) {
            int l = nums[i];
            int m = nums[i + 1];
            int r = nums[i + 2];
            
            if (l + r == m / 2.0) {
                res++;
            }
        }
        return res;
    }
}