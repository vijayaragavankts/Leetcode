/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // first find the peak index
        // then , the left half is in asc and right half is in desc, now apply binary
        // search ,
        // on both side to find the target
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // now peak index is in right or left.
        int left_side = binarySearch(0, right, mountainArr, target, true);
        int right_side = binarySearch(right, n - 1, mountainArr, target, false);
        if (left_side != -1) {
            return left_side;
        }
        if (right_side != -1) {
            return right_side;
        }
        return -1;
    }

    public int binarySearch(int start, int end, MountainArray mountainArr, int target, boolean flag) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (flag) {
                if (mountainArr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            else{
                if (mountainArr.get(mid) > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}