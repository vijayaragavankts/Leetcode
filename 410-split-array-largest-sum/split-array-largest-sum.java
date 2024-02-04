class Solution {
    public int splitArray(int[] nums, int k) {
        // binary search
        int left = 0;
        int right = 0;

        for(int i=0;i<nums.length;i++){
            left = Math.max(left,nums[i]);
            right += nums[i];
        }

        // nums = [7,2,5,10,8], k = 2

        // left = 10
        // right = 32

        // this is the range where our answer will present.
        while(left < right){
            int mid = left + (right-left)/2; // 21

            int count = 1;
            int sum = 0;

            for(int val:nums){
                if(sum + val > mid){
                    sum = val;
                    count++;
                }
                else{
                    sum += val;
                }
            }

            if(count > k){
                left = mid + 1;
            }
            else{
                right = mid;
            }
            
        }
        return left;
    }
}