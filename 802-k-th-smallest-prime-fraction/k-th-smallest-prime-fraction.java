class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double division = (double) arr[i] / arr[j];
                pq.offer(new double[]{division,(double)arr[i],(double)arr[j]});
            }
        }
        while(pq.size() > k){
            pq.poll();
        }
        double[] r1 = pq.poll();
        return new int[]{(int) r1[1], (int)r1[2]};
    }
}