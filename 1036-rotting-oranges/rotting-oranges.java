class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 1;
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        int t = 0;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            t = time;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r >= 0 && c >= 0 && r < m && c < n && visited[r][c] == 0 && grid[r][c] == 1){
                    queue.offer(new Pair(r,c,time+1));
                    visited[r][c] = 1;
                }
            }
        } 
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    return -1;
                }
            }
        }  
        return t;
    }
}