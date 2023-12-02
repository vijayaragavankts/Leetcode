class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i == n-1){
                    dp[i][j] = triangle.get(i).get(j);
                }
                else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j] , dp[i+1][j+1]);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}