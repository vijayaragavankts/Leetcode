class Solution {
    public int maxChunksToSorted(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            if(nums[i] >= max){
                max = nums[i];
            }
            if(i == max){
                count++;
            }
        }
        return count;
    }
}