class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row_one = new int[m];
        int[] row_zero = new int[m];
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum += grid[i][j];
            }
            row_one[i] = sum;
            row_zero[i] = m - sum;
        }

        int[] col_one = new int[n];
        int[] col_zero = new int[n];
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<m;j++){
                sum += grid[j][i];
            }
            col_one[i] = sum;
            col_zero[i] = n - sum;
        }

        // System.out.println(Arrays.toString(row_one));
        // System.out.println(Arrays.toString(row_zero));
        // System.out.println(Arrays.toString(col_one));
        // System.out.println(Arrays.toString(col_zero));


        int[][] res = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int oneRow = row_one[i];
                int oneCol = col_one[j];
                int zeroRow = row_zero[i];
                int zeroCol = col_zero[j];
                res[i][j] = oneRow + oneCol - zeroRow - zeroCol;
            }
        }
        return res;
    }
}