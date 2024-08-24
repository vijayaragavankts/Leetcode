class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        // Similar to lcs
        // find reverse string 
        // find lcs btw them that's ur answer
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String rev = sb.reverse().toString();
        int m = s.length();
        dp = new int[m][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(s,rev,m-1,m-1);
    }
    public int f(String s1, String s2, int i, int j){
        // base case
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int match = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            match = 1 + f(s1,s2,i-1,j-1);
        }
        else{
            match = Math.max(f(s1,s2,i-1,j) , f(s1,s2,i,j-1));
        }
        return dp[i][j] = match;
    }
}