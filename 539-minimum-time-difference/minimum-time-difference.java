class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        Collections.sort(timePoints);
        int[] minutes = new int[n];
        for(int i=0;i<n;i++){
            minutes[i] = convertToMinutes(timePoints.get(i));
        }
        System.out.println(Arrays.toString(minutes));

        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min = Math.min(min,minutes[i] - minutes[i-1]);
        }
        int circular = 1440 + (minutes[0] - minutes[minutes.length-1]);
        int res = Math.min(min,circular);
        return res;
    }
    public int convertToMinutes(String s){
        String arr[] = s.split(":");
        int hours = Integer.parseInt(arr[0]);
        int minutes = Integer.parseInt(arr[1]);
        return hours * 60 + minutes;
    }
}