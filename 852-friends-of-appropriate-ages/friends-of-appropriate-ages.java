class Solution {
    public int numFriendRequests(int[] ages) {
        int count = 0;
        int n = ages.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:ages){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            for(int j:map.keySet()){
                if(f(i, j)) {
                    count += map.get(i) * (map.get(j) - (i==j?1:0));
                }
            }
        }
        return count;
    }
    public boolean f(int i, int j){
        return !((j <= i*0.5+7) || (j>i) || (j>100 && i<100));
    }
}