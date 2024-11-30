class Pair{
    int row;
    int col;
    int obstacle;
    public Pair(int row, int col, int obstacle){
        this.row = row;
        this.col = col;
        this.obstacle = obstacle;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int[] arr:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a->a.obstacle));
        queue.offer(new Pair(0,0,0));
        dist[0][0] = 0;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int obstacle = queue.peek().obstacle;
            if(row == m-1 && col == n-1){
                return obstacle;
            }
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r >= 0 && c >= 0 && r < m && c < n){
                    int newObstacle = obstacle + grid[r][c];
                    if(dist[r][c] > newObstacle){
                        dist[r][c] = newObstacle;
                        queue.offer(new Pair(r,c,obstacle+grid[r][c]));
                    }
                }
            }
        }
        return 0;
    }
}