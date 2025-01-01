class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);




        int res = 0;
        for(int i=0;i<n;i++){
            int val = costs[i];
            if(val <= coins){
                coins -= val;
                res++;
            }
        }
        return res;
    }
}