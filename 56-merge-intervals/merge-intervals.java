class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
        for(int[] interval:intervals){
            // first interval or no overlap
            if(res.isEmpty() || interval[0] > res.getLast()[1]){
                res.add(interval);
            }
            // overlap so have to do something
            else{
                res.getLast()[1] = Math.max(res.getLast()[1] , interval[1]);
            }
        }
        // for(int[] arr: res){
        //     System.out.println(Arrays.toString(arr));
        // }
        return res.toArray(new int[res.size()][]);
    }
}