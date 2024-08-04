class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        int[] arr = new int[(n*(n+1))/2];
        int x = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                arr[x++] = sum;
            }
        }
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int res = 0;
        for(int i=left-1;i<right;i++){
            res = (res + arr[i]) % mod;
        }
        return res;
    }
}