class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        for(int i=0;i<n;i++){
            left = Math.min(left,nums[i]);
            right = Math.max(right,nums[i]);
        }

        while(left < right){
            int mid = left + (right-left)/2;
            if(sumOfValue(nums,mid) <= threshold){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int sumOfValue(int[] nums, int mid){
        int sum = 0;
        for(int val:nums){
            sum += Math.ceil((double)val / (double)mid);
        }
        
        return sum;
    }
}