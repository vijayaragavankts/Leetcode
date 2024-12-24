class Solution {
    final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int[] power = new int[n];
        power[0] = 1;
        for(int i=1;i<n;i++){
            power[i] = (power[i-1] * 2) % MOD;
        }
        while(l <= r){
            int sum = nums[l] + nums[r];
            if(sum <= target){
                res = (res + power[r-l]) % MOD;
                l++;
            }
            else if(sum > target){
                r--;
            }
        }
        return res;
    }
}