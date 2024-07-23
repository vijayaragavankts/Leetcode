class Solution {
    int[] drow = {-1,-2,-2,-1,+1,+2,+2,+1};
    int[] dcol = {-2,-1,+1,+2,+2,+1,-1,-2};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        return f(n,k,row,column,dp);
    }
    public double f(int n , int k, int i, int j,double[][][] dp){
        if(i < 0 || j < 0 || i >= n || j >= n){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        double rate = 0;
        for(int x=0;x<8;x++){
            rate += 0.125 * f(n,k-1,i + drow[x],j + dcol[x],dp);
        }
        return dp[i][j][k] = rate;
    }
}