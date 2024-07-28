class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                if(val == 1){ // island
                    if(i-1 < 0 || grid[i-1][j] == 0){
                        res++;
                    }
                    if(j-1 < 0 || grid[i][j-1] == 0){
                        res++;
                    }
                    if(i+1 >= m || grid[i+1][j] == 0){
                        res++;
                    }
                    if(j+1 >= n || grid[i][j+1] == 0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}