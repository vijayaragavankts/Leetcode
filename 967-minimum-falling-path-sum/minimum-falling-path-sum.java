class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int[][] dp = new int[m][n];
            for(int[] arr:dp){
                Arrays.fill(arr,(int)1e9);
            }
            int ans = f(0,i,m-1,matrix,dp);
            res = Math.min(res,ans);
        }
        return res;
    }
    public int f(int i, int j, int m, int[][] matrix, int[][] dp){
        if(j < 0 || j > m || i > m){
            return Integer.MAX_VALUE;
        }

        if(i == m){
            return matrix[i][j];
        }
        
        if(dp[i][j] != (int)1e9){
            return dp[i][j];
        }
        int left = f(i+1,j-1,m,matrix,dp);
        int st = f(i+1,j,m,matrix,dp);
        int right = f(i+1,j+1,m,matrix,dp);
        return dp[i][j] = Math.min(st,Math.min(left,right)) + matrix[i][j];
    }
}