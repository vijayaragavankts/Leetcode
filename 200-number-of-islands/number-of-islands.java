class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int x=0;x<4;x++){
            int row = i + drow[x];
            int col = j + dcol[x];
            if(row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == '1'){
                dfs(row,col,grid);
            }
        }
    }
}