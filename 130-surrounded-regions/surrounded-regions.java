class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        // 4 direction boundary check

        // 1st col
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
        }

        // last col
        for(int i=0;i<m;i++){
            if(board[i][n-1] == 'O'){
                dfs(i,n-1,board,vis);
            }
        }

        // 1st row
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board,vis);
            }
        }

        // last row
        for(int i=0;i<n;i++){
            if(board[m-1][i] == 'O'){
                dfs(m-1,i,board,vis);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int i, int j, char[][] board, int[][] vis){
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = 1;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int x=0;x<4;x++){
            int row = i + drow[x];
            int col = j + dcol[x];
            if(row >= 0 && col >= 0 && row < m && col < n && vis[row][col] == 0 && board[row][col] == 'O'){
                dfs(row,col,board,vis);
            }
        }
        return;
    }
}