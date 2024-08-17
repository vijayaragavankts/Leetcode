class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max_val = values[0];
        int max_idx = 0;
        int res = 0;

        for(int i=1;i<n;i++){
            res = Math.max(res , max_val + values[i] + max_idx - i);
            if(values[i] + i > max_val + max_idx){
                max_val = values[i];
                max_idx = i;
            }
        }
        return res;
    }
}