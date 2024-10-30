class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i=0;i<points.length-1;i++){
            int[] curr = points[i];
            int[] temp = points[i+1];
            int x = Math.abs(curr[0]-temp[0]);
            int y = Math.abs(curr[1]-temp[1]);
            res += Math.max(x,y);
        }

        return res;
    }
}