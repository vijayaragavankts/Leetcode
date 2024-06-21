class Solution {
    int res = 0;
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] > 0 && vis[i][j] == -1){
                    int sum = dfs(i,j,grid,vis);
                    System.out.println(sum);
                    res = Math.max(res,sum);
                }
            }
        }
        return res;
    }
    public int dfs(int i, int j, int[][] grid, int[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || vis[i][j] == 1){
            return 0;
        }
        int ans = grid[i][j];
        vis[i][j] = 1;
        ans += dfs(i-1,j,grid,vis);
        ans += dfs(i,j+1,grid,vis);
        ans += dfs(i+1,j,grid,vis);
        ans += dfs(i,j-1,grid,vis);

        return ans;
    }
}