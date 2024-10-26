class Solution {
    char[][] board;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(f(i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean f(int row, int col, String word, int idx){
        if (idx == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)){
            return false;
        }
        this.board[row][col] = '#';
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        boolean flag = false;
        for(int i=0;i<4;i++){
            int r = row + drow[i];
            int c = col + dcol[i];
            flag = f(r,c,word,idx+1);
            if(flag){
                break;
            }
        }
        this.board[row][col] = word.charAt(idx);
        return flag;
    }
}