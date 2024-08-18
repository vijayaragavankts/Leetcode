class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int a2 = 0;
        int a3 = 0;
        int a5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        int curr = 1;

        for(int i=1;i<n;i++){
            curr = Math.min(next2 , Math.min(next3 , next5));
            nums[i] = curr;

            if(curr == next2){
                a2++;
                next2 = nums[a2] * 2;
            }
            if(curr == next3){
                a3++;
                next3 = nums[a3] * 3;
            }
            if(curr == next5){
                a5++;
                next5 = nums[a5] * 5;
            }
        }
        return nums[n-1];
    }
}