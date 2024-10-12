class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int[] prev = intervals[0];

        int count = 0;

        for(int i=1;i<intervals.length;i++){
            int prevLast = prev[1];
            int currentFirst = intervals[i][0];
            int currentLast = intervals[i][1];

            if(currentFirst < prevLast){
                count++;
            }
            else{
                prev = intervals[i];
            }
        }
        return count;
    }
}