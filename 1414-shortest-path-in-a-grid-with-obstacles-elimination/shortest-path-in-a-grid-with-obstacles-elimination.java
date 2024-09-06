class Pair{
    int row;
    int col;
    int power;
    int distance;
    public Pair(int row, int col, int power, int distance){
        this.row = row;
        this.col = col;
        this.power = power;
        this.distance = distance;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],-1);
        }
        vis[0][0] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,k,0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int row = q.peek().row;
                int col = q.peek().col;
                int power = q.peek().power;
                int distance = q.peek().distance;
                q.poll();
                if(row == m-1 && col == n-1){
                    return distance;
                }
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int i=0;i<4;i++){
                    int r = row + drow[i];
                    int c = col + dcol[i];
                    if(r >= 0 && c >= 0 && r < m && c < n){
                        if(grid[r][c] == 1){
                            if(power > 0 && (vis[r][c] == -1 || vis[r][c] < power-1 )){
                                vis[r][c] = power-1;
                                q.offer(new Pair(r,c,power-1,distance+1));
                            }
                        }
                        else{
                            if(vis[r][c] == -1 || vis[r][c] < power){
                                vis[r][c] = power;
                                q.offer(new Pair(r,c,power,distance+1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}