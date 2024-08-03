class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String s:arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue() == 1){
                k--;
                if(k == 0){
                    return e.getKey();
                }
            }
        }
        return "";
    }
}