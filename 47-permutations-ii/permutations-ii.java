class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[nums.length];
        backtrack(nums, res, new ArrayList(), arr);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int[] arr) {
        if (list.size() == nums.length && !res.contains(list)) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == 0) {
                list.add(nums[i]);
                arr[i] = 1;
                backtrack(nums, res, list, arr);
                list.remove(list.size() - 1);
                arr[i] = 0;
            }
        }
    }
}