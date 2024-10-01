class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((hours[i] + hours[j]) % 24 == 0){
                    res++;
                }
            }
        }
        return res;
    }
}