class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int x = 0;
        for(int i=0;i<n;i++){
            int idx = nums[i];
            arr[x++] = nums[idx];
        }
        return arr;
    }
}