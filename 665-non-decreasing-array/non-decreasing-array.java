class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int current = nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                if(count == 1){
                    return false;
                }
                count++;
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
                
            }
            
        }
        System.out.println(count);
        return true;
    }
}