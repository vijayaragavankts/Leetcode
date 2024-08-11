class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] mat = new int[n][n];
        int i = 0, j = 0;
        int temp = 0;
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                mat[x][y] = temp++;
            }
        }
        int res = 0;
        for(String s: commands){
            if(s.equals("RIGHT")){
                res = mat[i][j+1];
                j++;
            }
            else if(s.equals("LEFT")){
                res = mat[i][j-1];
                j--;
            }
            else if(s.equals("UP")){
                res = mat[i-1][j];
                i--;
            }
            else{
                res = mat[i+1][j];
                i++;
            }
        }
        return res;
    }
}