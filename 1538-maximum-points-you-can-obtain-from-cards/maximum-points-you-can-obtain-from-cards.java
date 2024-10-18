class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = k-1;
        int max = 0, sum = 0;
        for(int i=l;i<=r;i++){
            sum += cardPoints[i];
        }
        max = sum;
        int r2 = n-1;
        while(r >= 0){
            sum -= cardPoints[r--];
            sum += cardPoints[r2--];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}