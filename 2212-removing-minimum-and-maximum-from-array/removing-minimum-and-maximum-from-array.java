class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_idx = -1;
        int min_idx = -1;
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val > max){
                max_idx = i;
                max = val;
            }
            if(val < min){
                min_idx = i;
                min = val;
            }
        }
        int res = 0;

        if (min_idx > max_idx) {
            int temp = min_idx;
            min_idx = max_idx;
            max_idx = temp;
        }


        // scenario 1 : Front

        int res1 = max_idx + 1;

        // scenario 2 : Back

        int res2 = n - min_idx;

        // scenario 3 : One from front and One from back

        int res3 = min_idx + 1 + n - max_idx;

        return Math.min(res1,Math.min(res2,res3));

    }
}