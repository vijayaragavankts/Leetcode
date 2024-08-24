class Solution {
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = pairs.length;
        dp = new int[m+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(pairs,0,-1,m);
    }
    public int f(int[][] nums, int i ,int j, int m){
        // base case
        if(i == m){
            return 0;
        }
        if(dp[i+1][j+1] != -1){
            return dp[i+1][j+1];
        }

        int notTake = f(nums,i+1,j,m);
        int take = 0;
        if(j == -1 || nums[i][0] > nums[j][1]){
            take = 1 + f(nums,i+1,i,m);
        }
        return dp[i+1][j+1] = Math.max(take,notTake);
    }
}