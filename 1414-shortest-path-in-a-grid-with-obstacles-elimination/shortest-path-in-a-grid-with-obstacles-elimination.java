class Pair{
    int row;
    int col;
    int power;
    int dist;
    public Pair(int row, int col, int power, int dist){
        this.row = row;
        this.col = col;
        this.power = power;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int[] arr:vis){
            Arrays.fill(arr,-1);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0,k,0));
        vis[0][0] = k;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int power = queue.peek().power;
            int dist = queue.peek().dist;
            queue.poll();
            if(row == m-1 && col == n-1){
                return dist;
            }
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r >= 0 && c >= 0 && r < m && c < n){
                    // inside the boundary
                    if(grid[r][c] == 1){
                        // obstacle
                        if(power > 0 && (vis[r][c] == -1 || vis[r][c] < power-1)){
                            queue.offer(new Pair(r,c,power-1,dist+1));
                            vis[r][c] = power-1;
                        }
                    }
                    else{
                        // no obstacle
                        if(vis[r][c] == -1 || vis[r][c] < power){
                        queue.offer(new Pair(r,c,power,dist+1));
                        vis[r][c] = power;
                        }
                    }
                }
            }
        }
        return -1;
    }
}