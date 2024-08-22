class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(text1,text2,m-1,n-1);
    }
    public int f(String s1, String s2, int i, int j){
        // base cases
        if(i == -1 || j == -1){
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