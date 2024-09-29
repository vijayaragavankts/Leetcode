class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int num:nums){
            int sum = 0;
            while(num != 0){
                int rem = num % 10;
                sum += rem;
                num = num / 10;
            }
            res = Math.min(res,sum);
        }
        return res;
    }
}