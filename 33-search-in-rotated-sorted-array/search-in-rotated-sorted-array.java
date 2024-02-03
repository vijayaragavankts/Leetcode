class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            // the property of the rotated sorted array is , where you stand is not important
            // but either left side or right side is sorted
            else if(nums[left] <= nums[mid]){ // left side is sorted
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{ // right side is sorted
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}