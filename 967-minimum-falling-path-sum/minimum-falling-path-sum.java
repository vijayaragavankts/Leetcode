class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int[][] dp = new int[n][n];
            for(int[] arr:dp){
                Arrays.fill(arr,(int)1e9);
            }
            int ans = f(0,i,matrix,dp);
            res = Math.min(res,ans);
        }
        return res;
    }
    public int f(int i, int j, int[][] matrix, int[][] dp){
        int n = matrix.length;
        if(j < 0 || j >= n){
            return Integer.MAX_VALUE;
        }
        if(i == n-1){
            return matrix[i][j];
        }
        if(dp[i][j] != (int)1e9){
            return dp[i][j];
        }
        int bottom = f(i+1,j,matrix,dp);
        int bottom_left = f(i+1,j-1,matrix,dp);
        int bottom_right = f(i+1,j+1,matrix,dp);
        return dp[i][j] = Math.min(bottom,Math.min(bottom_left,bottom_right)) + matrix[i][j];
    }
}