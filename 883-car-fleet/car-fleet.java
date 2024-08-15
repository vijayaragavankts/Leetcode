class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));
        double prev = 0;
        int count = 0;
        for(double[] arr:cars){
            if(arr[1] > prev){
                count++;
                prev = arr[1];
            }
        }
        return count;
    }
}