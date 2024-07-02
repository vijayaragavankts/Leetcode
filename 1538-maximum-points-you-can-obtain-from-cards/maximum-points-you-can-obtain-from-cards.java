class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int r = k-1;
        int max = 0;
        int n = cardPoints.length;
        int sum = 0;
        for(int i=l;i<=r;i++){
            sum += cardPoints[i];
        }
        if(sum > max){
            max = sum;
        }
        // System.out.println(sum);
        int r2 = n-1;
        while(r >= 0){
            sum = sum - cardPoints[r];
            r--;
            sum += cardPoints[r2];
            r2--;
            if(sum > max){
                max = sum;
            }
            // System.out.println(max);
        }
        return max;
    }
}