class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(triangle,0,0,n-1,dp);
    }
    public int f(List<List<Integer>> list, int i, int j, int n, int[][] dp){
        if(j < 0 || j > list.get(i).size()){
            return Integer.MAX_VALUE;
        }
        if(i == n){
            return list.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = f(list,i+1,j,n,dp);
        int diagonal = f(list,i+1,j+1,n,dp);
        return dp[i][j] = Math.min(down,diagonal) + list.get(i).get(j);
    }
}