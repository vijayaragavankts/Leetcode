class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= (int)nums[i];
            suffix *= (int)nums[n-i-1];
            if(suffix<(Integer.MAX_VALUE)/2 || prefix<(Integer.MAX_VALUE)/2)
                max = Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}