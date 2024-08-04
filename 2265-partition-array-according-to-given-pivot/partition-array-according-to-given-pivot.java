class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] arr = new int[n];
        int x = 0;
        int same_counter = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < pivot){
                arr[x++] = nums[i];
            }
            if(nums[i] == pivot){
                same_counter++;
            }
        }
        while(same_counter-- > 0){
            arr[x++] = pivot;
        }
        for(int i=0;i<n;i++){
            if(nums[i] > pivot){
                arr[x++] = nums[i];
            }
        }
        return arr;
    }
}