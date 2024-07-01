class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int val:arr){
            if(val % 2 == 1){
                count++;
            }
            else if(val % 2 == 0){
                count = 0;
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }
}