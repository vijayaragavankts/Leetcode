class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = groupSizes[i];
            map.putIfAbsent(val,new ArrayList<>());
            map.get(val).add(i);
            if(map.get(val).size() == val){
                res.add(new ArrayList<>(map.get(val)));
                map.get(val).clear();
            }
        }
        return res;
    }
}