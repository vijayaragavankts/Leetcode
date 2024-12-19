class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + (double) 273.15;
        res[1] = (celsius * (double) 1.80) + (double) 32.00;
        return res;
    }
}