class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            if(arr[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
        
    }
}