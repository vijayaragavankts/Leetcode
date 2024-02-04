class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int val:piles){
            if(val > right){
                right = val;
            }
        }
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(findTotalHours(piles,mid) <= h){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int findTotalHours(int[] piles, int k){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            total +=  Math.ceil((double)piles[i]/k);
        }
        System.out.println();
        return total;
    }
}