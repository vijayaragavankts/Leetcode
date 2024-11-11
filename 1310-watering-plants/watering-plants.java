class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int n = plants.length;
        int x = capacity;
        for(int i=0;i<n;i++){
            if(x >= plants[i]){
                x -= plants[i];
                res++;
            }
            else{
                x = capacity;
                x -= plants[i];
                res += ((i+1)*2)-1;
            }
        }


        return res;
    }
}