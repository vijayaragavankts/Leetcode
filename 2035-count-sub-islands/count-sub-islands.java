class Solution {
    boolean flag;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int m = grid1.length;
        int n = grid1[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j] == 1){
                    flag = true;
                    dfs(i,j,grid1,grid2);
                    if(flag){
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, int[][] grid1, int[][] grid2){
        int m = grid1.length;
        int n = grid1[0].length;

        if(grid1[i][j] != grid2[i][j]){
            flag = false;
        }

        grid2[i][j] = 0;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int x=0;x<4;x++){
            int row = i + drow[x];
            int col = j + dcol[x];
            if(row >= 0 && col >= 0 && row < m && col < n && grid2[row][col] == 1){
                dfs(row,col,grid1,grid2);
            }
        }
        return;
    }
}