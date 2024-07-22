class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int res = 0;
        for(int i=left;i<=right;i++){
            res += arr[i];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */