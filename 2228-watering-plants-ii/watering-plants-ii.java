class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int x = capacityA;
        int y = capacityB;
        int n = plants.length;
        int l = 0, r = n-1;
        while(l < r){
            if(plants[l] <= x){
                x -= plants[l];
            }
            else{
                res++;
                x = capacityA;
                x -= plants[l];
            }
            l++;
            if(plants[r] <= y){
                y -= plants[r];
            }
            else{
                res++;
                y = capacityB;
                y -= plants[r];
            }
            r--;
        }
        if (l == r) {
            if (x >= y) {
                if (plants[l] > x) {
                    res++;
                }
            } else {
                if (plants[r] > y) {
                    res++;
                }
            }
        }


        return res;
    }
}