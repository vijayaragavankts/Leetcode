class Pair{
    int row;
    int col;
    int distance;
    Pair(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int entrow = entrance[0];
        int entcol = entrance[1];
        if(maze[entrow][entcol] == '+'){
            return -1;
        }
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j] = -1;
            }
        }
        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(entrow,entcol,0));
        vis[entrow][entcol] = 1;
        while(!queue.isEmpty()){
            res++;
            int size = queue.size();
            while(size-- > 0){
                int r = queue.peek().row;
                int c = queue.peek().col;
                int dist = queue.peek().distance;
                queue.poll();
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int k=0;k<4;k++){
                    int row = r + drow[k];
                    int col = c + dcol[k];
                    if(row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == '.' && vis[row][col] == -1){
                        if(row == 0 || col == 0 || row == m-1 || col == n-1){
                            return res;
                        }
                        queue.offer(new Pair(row,col,dist+1));
                        vis[row][col] = 1;
                    }
                }
            }
        }
        return -1;
    }
}