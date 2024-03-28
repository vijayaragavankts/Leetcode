class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);    
            }
            else{
                map.put(nums[i],1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() == max){
                count += e.getValue();
            }
        }
        return count;
    }
}