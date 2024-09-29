class Solution {
    public long maximumTotalSum(int[] nums) {
        int n = nums.length;
        long res = 0;
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray,Collections.reverseOrder());
        int curr = numsArray[0];
        res += curr;
        for(int i=1;i<n;i++){
            curr = Math.min(numsArray[i],curr-1);
            if(curr < 1){
                return -1;
            }
            res += curr;
        }
        return res;
    }
}