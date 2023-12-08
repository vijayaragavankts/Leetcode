class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int max_len = 0;
        String res = s.charAt(0) + "";
        // fill in diagonal
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
            if(i != len-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
            }
        }
        for(int k=1;k<len;k++){
            for(int i=0,j=k;i<len && j<len;i++,j++){
                if(dp[i][j] != 1){
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        if(j - i + 1 > max_len){
                            max_len = j - i + 1;
                            res = s.substring(i,j+1);
                        }
                    }
                }
                else if(dp[i][j] == 1 && j - i + 1 > max_len){
                    max_len = j - i + 1;
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}