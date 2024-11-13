class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int lower1 = lower_bound(nums,i+1,n,lower-nums[i]);
            int upper1 = upper_bound(nums,i+1,n,upper-nums[i]);
            res += (upper1 - lower1);
        }
        return res;
    }
    public int lower_bound(int[] nums, int start, int end, int target){
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    public int upper_bound(int[] nums, int start, int end, int target){
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}