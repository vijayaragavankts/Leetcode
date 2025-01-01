class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int temp = additionalRocks;
        System.out.println(Arrays.toString(diff));
        int res = 0;
        for(int i=0;i<n;i++){
            if(diff[i] == 0){
                res++;
            }
            else if(diff[i] <= temp){
                temp -= diff[i];
                res++;
            }
        }
        return res;
    }
}