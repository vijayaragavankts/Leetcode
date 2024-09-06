class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestBridge(int[][] grid) {
        // there are totally 2 components
        // the idea is to convert one component into lets say 5
        // another component will be lets say 10
        // now its similar to find the min distance btw 2 components
        // bfs

        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        Queue<Pair> q2 = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    // bfs();
                    bfs(i,j,grid,q2);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        int steps = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        while (!q2.isEmpty()) {
            int size = q2.size();
            while (size-- > 0) {
                Pair current = q2.poll();
                int r = current.row;
                int c = current.col;

                for (int k = 0; k < 4; k++) {
                    int row = r + drow[k];
                    int col = c + dcol[k];

                    if (row >= 0 && col >= 0 && row < m && col < n) {
                        if (grid[row][col] == 1) {
                            return steps;
                        }
                        if (grid[row][col] == 0) {
                            grid[row][col] = 10;
                            q2.offer(new Pair(row, col));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public void bfs(int i, int j, int[][] grid,Queue<Pair> q2){
        Queue<Pair> queue = new LinkedList<>();
        q2.offer(new Pair(i,j));
        queue.offer(new Pair(i,j));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int r = queue.peek().row;
                int c = queue.peek().col;
                queue.poll();
                grid[r][c] = 10;
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int k=0;k<4;k++){
                    int row = r + drow[k];
                    int col = c + dcol[k];
                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1){
                        grid[row][col] = 10;
                        queue.offer(new Pair(row,col));
                        q2.offer(new Pair(row,col));
                    }
                }
            }
        }
    }
}