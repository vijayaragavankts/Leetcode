class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int freqCompare = a.getValue().compareTo(b.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });
        System.out.println(list);
        int[] arr = new int[n];
        int x = 0;
        for(Map.Entry<Integer,Integer> e:list){
            int element = e.getKey();
            int iter = e.getValue();
            for(int i=1;i<=iter;i++){
                arr[x++] = element;
            }
        }
        return arr;
    }
}