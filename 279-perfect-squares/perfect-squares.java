class Solution {
    public int numSquares(int n) {
        int[] arr = new int[(int)Math.sqrt(n)];
        for(int i=0;i<arr.length;i++){
            arr[i] = (i+1) * (i+1);
        }
        System.out.println(Arrays.toString(arr));
        int[][] dp = new int[arr.length][n+1];
        return f(arr,arr.length-1,n,dp);

    }
    public int f(int[] arr, int index, int target,int[][] dp){
        if(index == 0){
            if(target % arr[index] == 0){
                return target / arr[index];
            }
            return 0;
        }
        if(dp[index][target] != 0){
            return dp[index][target];
        }
        
        int take = Integer.MAX_VALUE;
        int notTake = 0 + f(arr,index-1,target,dp);
        if(arr[index] <= target){
            take = 1 + f(arr,index,target-arr[index],dp);
        }
        return dp[index][target] = Math.min(take,notTake);
    }
}