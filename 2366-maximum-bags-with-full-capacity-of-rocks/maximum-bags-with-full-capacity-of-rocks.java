class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int res = 0;
        for(int i=0;i<n;i++){
            if(diff[i] == 0){
                res++;
            }
            else if(diff[i] <= additionalRocks){
                additionalRocks -= diff[i];
                res++;
            }
            else{
                break;
            }
        }
        return res;
    }
}