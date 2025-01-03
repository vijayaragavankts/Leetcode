class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }
            else{
                map.put(val,1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int val:nums){
            if(!map.containsKey(val-1) && !map.containsKey(val+1) && map.containsKey(val) && map.get(val) == 1){
                res.add(val);
            }
        }
        return res;
    }
}