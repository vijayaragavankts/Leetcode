class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}