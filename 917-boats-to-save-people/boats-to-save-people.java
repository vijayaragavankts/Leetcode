
class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;  
        int l = 0;    
        int r = n-1;

        while(l <= r){
            int sum = nums[l] + nums[r];
            if(sum <= limit){
                l++;
            }
            r--;
            res++;

        }

        return res;
    }
}
