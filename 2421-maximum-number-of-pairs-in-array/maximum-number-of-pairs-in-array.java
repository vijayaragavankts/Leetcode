class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
    
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            res[0] += e.getValue() / 2;
        }

        res[1] = nums.length - res[0] * 2;
        return res;
    }
}