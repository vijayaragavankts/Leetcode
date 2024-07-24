class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int val:nums){
            freq.put(val,freq.getOrDefault(val,0)+1);
        }
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String num = nums[i] + ""; // 991 -----> 669
            int val = 0;
            int len = num.length();
            for(int j=0;j<len;j++){
                int ch = num.charAt(j) - '0';
                int relevant = mapping[ch];
                val = val * 10;
                val += relevant;
            }
            map.put(nums[i],val);
        }
        // System.out.println(map);

        // Convert the map's entries to a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list based on values
        list.sort(Map.Entry.comparingByValue());
        int[] res = new int[n];
        int x = 0;
        for(Map.Entry<Integer,Integer> e:list){
            int element = e.getKey();
            int iter = freq.get(element);
            for(int i=1;i<=iter;i++){
                res[x++] = element;
            }
        }
        // System.out.println(list);
        return res;
    }
}