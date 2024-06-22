class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int original = image[sr][sc];
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = image[i][j];
            }
        }
        dfs(sr,sc,image,original,color,res);
        return res;
    }
    public void dfs(int i, int j, int[][] image, int original, int color, int[][] res){
        int m = image.length;
        int n = image[0].length;
        res[i][j] = color;
        image[i][j] = -1;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int x=0;x<4;x++){
            int row = i + drow[x];
            int col = j + dcol[x];
            if(row >= 0 && col >= 0 && row < m && col < n && image[row][col] == original){
                dfs(row,col,image,original,color,res);
            }
        }
        return;
    }
}