class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        String res = "";
        for(char ch:order.toCharArray()){
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count > 0){
                    res += ch;
                    count--;
                }
                map.remove(ch);
            }
        }
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            int count = e.getValue();
            char val = e.getKey();
            while(count > 0){
                res += val;
                count--;
            }
        }
        return res;
    }
}