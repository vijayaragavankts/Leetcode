class Solution {
    int mod = 1000000007;
    public int numTilings(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        if(n == 3){
            return 5;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 5;
        for(int i=4;i<=n;i++){
            res[i] = (2 * res[i-1] % mod + res[i-3] % mod) % mod;
        }
        return res[n] % mod;
    }
}