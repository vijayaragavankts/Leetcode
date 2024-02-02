class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean flag) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (flag) {
                    ans = mid;
                    right = mid-1;
                }
                else{
                    ans = mid;
                    left = mid + 1;
                }

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}