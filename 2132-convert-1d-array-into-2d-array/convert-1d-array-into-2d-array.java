class Solution {
    public int[][] construct2DArray(int[] nums, int m, int n) {
        int size = nums.length;
        int[][] mat = new int[m][n];
        if(size > m*n){
            return new int[0][0];
        }
        else if(size < m * n){
            return new int[0][0];
        }
        int x = 0;
        if(size == m*n){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = nums[x++];
                }
            }
        }
        return mat;
    }
}