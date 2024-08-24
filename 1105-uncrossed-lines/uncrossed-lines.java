class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // LCS
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(nums1,nums2,m-1,n-1);
    }
    public int f(int[] s1, int[] s2, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int match = 0;
        if(s1[i] == s2[j]){
            match = 1 + f(s1,s2,i-1,j-1);
        }
        else{
            match = Math.max(f(s1,s2,i-1,j) , f(s1,s2,i,j-1));
        }
        return dp[i][j] = match;
    }
}