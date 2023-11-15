class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int res = f(m-1,n-1,s,p,dp);
        return res == 1 ? true : false;
    }
    public int f(int i, int j, String s, String p, int[][] dp){
        if(i < 0 && j < 0){
            return 1;
        }
        if(i < 0 && j >= 0){
            if(isStar(j,p)){
                return 1;
            }
            return 0;
        }
        if(i >= 0 && j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j)){
            return dp[i][j] = f(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j) == '?'){
            return dp[i][j] = f(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j) == '*'){
            if(f(i-1,j,s,p,dp) == 1 || f(i,j-1,s,p,dp) == 1){
                dp[i][j] = 1;
                return 1;
            }
            dp[i][j] = 0;
            return 0;
        }
        dp[i][j] = 0;
        return 0;
    }
    public boolean isStar(int i, String str){
        for(int x=0;x<=i;x++){
            if(str.charAt(x) != '*'){
                return false;
            }
        }
        return true;
    }
}