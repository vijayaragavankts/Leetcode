class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n-2;
        if(n == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid-1] == nums[mid]){
                if((mid-1)%2 == 0){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            
            else if(nums[mid+1] == nums[mid]){
                if((mid)%2 == 0){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            
            else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}