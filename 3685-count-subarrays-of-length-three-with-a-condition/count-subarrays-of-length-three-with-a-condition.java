class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=2;i<n;i++){
            int x = nums[i-2];
            int y = nums[i-1];
            int z = nums[i];
            if(x + z == y / 2.0){
                res++;
            }
        }
        return res;
    }
}