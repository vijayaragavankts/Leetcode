class Solution {
    public int maxDistance(List<List<Integer>> list) {

        int min = list.get(0).get(0);
        int max = list.get(0).get(list.get(0).size()-1);

        int res = 0;
        for(int i=1;i<list.size();i++){
            int curr_min = list.get(i).get(0);
            int curr_max = list.get(i).get(list.get(i).size()-1);
            res = Math.max(res , Math.abs(min - curr_max));
            res = Math.max(res , Math.abs(max - curr_min));

            min = Math.min(min, curr_min);
            max = Math.max(max, curr_max);
        }

        return res;
    }
}