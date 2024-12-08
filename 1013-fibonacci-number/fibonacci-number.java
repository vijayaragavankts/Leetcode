class Solution {
    public int fib(int n) {
        double sqr_5 = Math.sqrt(5);
        double phi = (1 + sqr_5)/2;
        double psi = (1 - sqr_5)/2;
        return (int)((Math.pow(phi,n) - Math.pow(psi,n))/sqr_5);
    }
}