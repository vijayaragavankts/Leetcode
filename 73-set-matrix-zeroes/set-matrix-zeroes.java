class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    changeRow(matrix,i);
                    changeColumn(matrix,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == -10){
                    matrix[i][j] = 0;
                }
            }
        }
    }   
    public void changeRow(int[][] mat, int row){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<n;i++){
            if(mat[row][i] != 0){
                mat[row][i] = -10;
            }
        }
    }
    public void changeColumn(int[][] mat, int col){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            if(mat[i][col] != 0){
                mat[i][col] = -10;
            }
        }
    }
}