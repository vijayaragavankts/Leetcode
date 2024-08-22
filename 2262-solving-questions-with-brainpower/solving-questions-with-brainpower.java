class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        int m = questions.length;
        dp = new long[m];
        Arrays.fill(dp,-1);
        return f(questions,0,m);
    }
    public long f(int[][] mat, int i, int m){
        // base case

        if(i >= m){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        long notTake = f(mat,i+1,m);
        long take = f(mat,i+mat[i][1]+1,m) + mat[i][0];

        return dp[i] = Math.max(take,notTake);
    }
}