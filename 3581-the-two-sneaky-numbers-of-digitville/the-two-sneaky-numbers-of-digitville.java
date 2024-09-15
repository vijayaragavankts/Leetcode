class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for(int num:nums){
            count[num]++;
        }
        int[] res = new int[2];
        int x = 0;
        for(int i=0;i<n;i++){
            if(count[i] >= 2){
                res[x++] = i;
            }
        }
        return res;
    }
}