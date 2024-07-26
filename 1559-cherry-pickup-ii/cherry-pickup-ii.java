class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return f(grid,0,0,n-1,dp);
    }
    public int f(int[][] grid, int i, int j1, int j2, int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;
        // out of bounds check
        if(j1 < 0 || j2 < 0 || j1 >= n || j2 >= n){
            return Integer.MIN_VALUE;
        }
        if(i == m-1){ // reached last row
            if(j1 == j2){
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        // -1, 0 , +1
        int maxi = 0;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                int val = 0;
                if(j1 == j2){
                    val = grid[i][j1];
                }
                else{
                    val = grid[i][j1] + grid[i][j2];
                }
                val += f(grid,i+1,j1 + x,j2 + y, dp);
                maxi = Math.max(val,maxi);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}