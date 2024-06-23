class Pair{
    int first;
    int second;
    int time;
    public Pair(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){ // checks for rotten oranges
                    // do something
                    queue.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int time = bfs(queue,grid,vis);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    return -1;
                }
            }
        }
        return time;

    }
    public int bfs(Queue<Pair> queue, int[][] grid, int[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        
        int time = 0;
        

        while(!queue.isEmpty()){
            int first = queue.peek().first;
            int second = queue.peek().second;
            time = queue.peek().time;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int x=0;x<4;x++){
                int row = first + drow[x];
                int col = second + dcol[x];
                if(row >= 0 && col >= 0 && row < m && col < n && vis[row][col] == 0 && grid[row][col] == 1){
                    queue.offer(new Pair(row,col,time+1));
                    vis[row][col] = 1;
                }
            }
        }
        
        return time;
    }
}