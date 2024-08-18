class Solution {
    public int countPrimes(int n) {
        if(n == 0){
            return 0;
        }
        int[] nums = new int[n+1];
        Arrays.fill(nums,1);
        // System.out.println(Arrays.toString(nums));
        for(int i=2;i*i<n;i++){
            if(nums[i] == 1){
                for(int j=i*i;j<n;j+=i){
                    nums[j] = 0;
                }
            }
        }
        // System.out.println(Arrays.toString(nums));
        int count = 0;
        for(int i=2;i<n;i++){
            if(nums[i] == 1){
                count++;
            }
        }
        return count;
    }
}