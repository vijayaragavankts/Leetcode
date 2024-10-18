class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer ceiling = set.ceiling(nums[i] - valueDiff);
            
            // Check if such a number exists and is within the valueDiff range
            if (ceiling != null && ceiling <= nums[i] + valueDiff) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}