class Pair{
    int row;
    int col;
    int dis;
    public Pair(int row,int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // bfs
        int[][] vis = new int[m][n];
        int[][] res = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0){
                    if(mat[i][j] == 0){
                        queue.offer(new Pair(i,j,0));
                        vis[i][j] = 1;
                    }   
                }
            }
        }

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int d = queue.peek().dis;
            res[r][c] = d;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int x=0;x<4;x++){
                int row = r + drow[x];
                int col = c + dcol[x];
                if(row >= 0 && col >= 0 && row < m && col < n && vis[row][col] == 0 && mat[row][col] == 1){
                    queue.offer(new Pair(row,col,d+1));
                    res[row][col] = d+1;
                    vis[row][col] = 1;
                }
            }
        }

        return res;
    }
    public void bfs(int i, int j, int[][] mat, int[][] vis, int[][] res){
        int m = mat.length;
        int n = mat[0].length;
        vis[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i,j,1));
        res[i][j] = 1;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int x=0;x<4;x++){
                int row = r + drow[x];
                int col = c + dcol[x];
                if(row >= 0 && col >= 0 && row < m && col < n && mat[row][col] == 1){

                }
            }
        }
    }
}