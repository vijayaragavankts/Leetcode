class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][5000];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(mat,target,0,0,dp);
        
    }
    public int f(int[][] mat, int target , int i, int val, int[][] dp){
        if(i == mat.length){
            return Math.abs(target - val);
        }
        if(dp[i][val] != -1){
            return dp[i][val];
        }
        int ans = Integer.MAX_VALUE;
        for(int x=0;x<mat[0].length;x++){
            ans = Math.min(ans,f(mat,target,i+1,val+mat[i][x],dp));
        }
        return dp[i][val] = ans;
    }
}