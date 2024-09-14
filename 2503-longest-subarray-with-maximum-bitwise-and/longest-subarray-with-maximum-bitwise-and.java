class Solution {
    public int longestSubarray(int[] nums) {
        // my intuition
        // find max
        // find the subarray length of max element value
        int max = Integer.MIN_VALUE;
        for(int val:nums){
            if(val > max){
                max = Math.max(max,val);
            }
        }
        int count = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == max){
                temp++;
                count = Math.max(count,temp);
            }
            else{
                temp = 0;
            }
        }
        return count;
    }
}