class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>();
        int n = names.length;
        for(int i=0;i<n;i++){
            map.put(heights[i],names[i]);
        }
        String[] res = new String[n];
        for(Map.Entry<Integer,String> e:map.entrySet()){
            res[--n] = e.getValue();
        }
        return res;
    }
}