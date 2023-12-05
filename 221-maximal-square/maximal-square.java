class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0 || matrix[i][j] == '0'){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    int up_left = dp[i-1][j-1];
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = Math.min(left,Math.min(up_left,up)) + 1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j] + " ");
            }   
            System.out.println();
        }
        return max * max;
    }
}
