class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();
        for(int[] interval:intervals){
            newIntervals.add(interval);
        }
        newIntervals.add(newInterval);

        // sorting happens here
        Collections.sort(newIntervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();

        for(int[] interval:newIntervals){
            // res is empty or no overlap , then add it to the res list
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            }
            // overlap is there
            else{
                res.getLast()[1] = Math.max(res.getLast()[1] , interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}