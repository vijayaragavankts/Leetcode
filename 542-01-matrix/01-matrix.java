class Pair{
    int row;
    int col;
    int distance;
    public Pair(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] res = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int distance = queue.peek().distance;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};

            for(int k=0;k<4;k++){
                int r = row + drow[k];
                int c = col + dcol[k];
                if(r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == 0 && mat[r][c] == 1){
                    queue.offer(new Pair(r,c,distance+1));
                    vis[r][c] = 1;
                    res[r][c] = distance + 1;
                }
            }
        }
        return res;
    }
}