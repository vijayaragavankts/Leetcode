class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max_diagonal = 0;
        int max_area = 0;
        for(int[] arr:dimensions){
            int length = arr[0];
            int width = arr[1];
            int diagonal = (length * length) + (width * width);
            if(diagonal > max_diagonal || (diagonal == max_diagonal && length * width > max_area)){
                max_area = length * width;
                max_diagonal = diagonal;
            }
        }
        return max_area;
    }
}