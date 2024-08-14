class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=k;i<=num;i+=10){
            if(i != 0){
                list.add(i);
            }
        }
        int n = list.size();
        int[][] dp = new int[n][num+1];
        // [9,19,29,39,49] -----> target = 58 -----> res = [9,49]
        int val = f(list,n-1,num,dp);
        return val == (int)1e9 ? -1 : val;
    }
    public int f(List<Integer> nums, int i, int target, int[][] dp){
        if(i < 0){
            return (int)1e9;
        }
        if(i == 0){
            if(target % nums.get(i) == 0){
                return target / nums.get(i);
            }
            return (int)1e9;
        }
        if(dp[i][target] != 0){
            return dp[i][target];
        }
        int notTake = 0 + f(nums, i-1,target,dp);
        int take = (int)1e9;
        if(target >= nums.get(i)){
            take = 1 + f(nums,i,target-nums.get(i),dp);
        }
        return dp[i][target] = Math.min(take,notTake);
    }
}