class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<nums.length;i++){
            int sum = nums[i-1] + nums[i];
            if(set.contains(sum)){
                return true;
            }
            else{
                set.add(sum);
            }
        }
        return false;
    }
}