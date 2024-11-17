class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int original_color = image[sr][sc];
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr,sc));
        vis[sr][sc] = true;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            image[row][col] = color;
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int k=0;k<4;k++){
                int r = row + drow[k];
                int c = col + dcol[k];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == original_color && vis[r][c] == false){
                    queue.offer(new Pair(r,c));
                    vis[r][c] = true;
                }
            }
        }
        return image;
    }
}