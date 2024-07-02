class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0;
        while(r < n){
            if(nums[r] == 0){
                count++;
            }
            while(count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                int len = r - l + 1;
                max = Math.max(max,len);
                r++;
            }
        }
        return max;
    }
}