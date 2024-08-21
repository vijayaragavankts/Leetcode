class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        dp = new int[m+1][n+1][strs.length+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=strs.length;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(strs,len-1,m,n,0,0);
    }
    public int f(String[] nums, int i, int m, int n , int zero, int one){
        // base case
        if(zero > m || one > n){
            return Integer.MIN_VALUE;
        }
        if((m == zero && n == one) || i < 0){
            return 0;
        }
        
        if(dp[zero][one][i] != -1){
            return dp[zero][one][i];
        }

        int pick = 0;
        if(isValid(nums[i],m,n,zero,one)){
            int count_zero = calc_zero(nums[i]);
            int count_one = calc_one(nums[i]);
            pick = 1 + f(nums,i-1,m,n,zero + count_zero,one + count_one);
        }
        int notPick = 0 + f(nums,i-1,m,n,zero,one);
        return dp[zero][one][i] = Math.max(pick,notPick);
    }

    public boolean isValid(String s, int m ,int n, int zero, int one){
        int count_0 = calc_zero(s);
        int count_1 = calc_one(s);
        if(count_0 <= m && count_1 <= n){
            return true;
        }
        return false;
    }

    public int calc_zero(String s){
        int count = 0;
        for(char c:s.toCharArray()){
            if(c == '0'){
                count++;
            }
        }
        return count;
    }

    public int calc_one(String s){
        int count = 0;
        for(char c:s.toCharArray()){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }
}