class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int x = 10;
    int y = 10;
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int[][] vis = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],-1);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j] == 1 && vis[i][j] == -1){
                    list.add(i);
                    list.add(j);
                    bfs(i,j,land,vis);
                    System.out.println(x + " " + y);
                    list.add(x);
                    list.add(y);
                }
            }
        }
        System.out.println("Printing List: ");
        System.out.println(list);
        int k = 0;
        int[][] mat = new int[list.size()/4][4];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = list.get(k++);
            }
        }
        return mat;
    }

    public void bfs(int i, int j, int[][] land, int[][] vis){
        int m = land.length;
        int n = land[0].length;
        x = i;
        y = j;
        vis[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i,j));
        while(!queue.isEmpty()){
            int first = queue.peek().first;
            int second = queue.peek().second;
            queue.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};

            for(int p=0;p<4;p++){
                int row = first + drow[p];
                int col = second + dcol[p];
                if(row >= 0 && col >= 0 && row < m && col < n && vis[row][col] == -1 && land[row][col] == 1){
                    queue.offer(new Pair(row,col));
                    x = row;
                    y = col;
                    vis[row][col] = 1;
                }
            }
        }
        return;
    }
}