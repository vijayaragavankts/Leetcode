class Solution {
    public double[] sampleStats(int[] count) {
        int n = count.length;
        double min = -1; 
        double max = 0;
        double mean = 0;
        double median = 0;
        double mode = 0;

        long sum = 0;
        int totalCount = 0;
        int modeCount = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }
                max = i;
                sum += (long) i * count[i];
                totalCount += count[i];
                if (count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
            }
        }

        mean = (double) sum / totalCount;

        int mid1 = (totalCount + 1) / 2; 
        int mid2 = (totalCount % 2 == 0) ? (totalCount / 2 + 1) : mid1;

        int cumulativeCount = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                cumulativeCount += count[i];
                if (cumulativeCount >= mid1 && median == 0) {
                    median += i;
                }
                if (cumulativeCount >= mid2) {
                    median += i;
                    median /= 2.0;
                    break;
                }
            }
        }

        double[] res = new double[5];
        res[0] = min;
        res[1] = max;
        res[2] = mean;
        res[3] = median;
        res[4] = mode;

        return res;
    }
}
