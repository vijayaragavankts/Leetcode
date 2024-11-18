class Pair{
    int distance;
    int row;
    int col;
    public Pair(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, 0, 0));
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            int distance = pq.peek().distance;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();
            if(row == m-1 && col == n-1){
                return distance + 1;
            }
            int[] drow = {-1, -1, -1, 0, 1, 1,  1,  0};
            int[] dcol = {-1,  0,  1, 1, 1, 0, -1, -1};
            for(int i=0;i<8;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && distance + 1 < dist[r][c]){
                    dist[r][c] = distance + 1;
                    pq.offer(new Pair(dist[r][c], r , c));
                }
            }
        }
        return -1;
    }
}