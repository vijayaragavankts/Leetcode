class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = fruits.length;
        int res = 0;
        while(r < n){
            
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            
            while(map.size() > 2){
                // issue
                int remove_ele = fruits[l];
                map.put(remove_ele,map.get(remove_ele)-1);
                if(map.get(remove_ele) == 0){
                    // remove that key value pair
                    map.remove(remove_ele);
                }
                l++;
            }
            if(map.size() <= 2){
                // no issue
                res = Math.max(res,r-l+1);
                r++;
            }
        }
        return res;
    }
}