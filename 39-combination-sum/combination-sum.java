class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        backtrack(candidates, target, res, new ArrayList(), 0);
        return res;
    }
    public void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){

            list.add(nums[i]);
            backtrack(nums,target-nums[i],res,list,i);
            list.remove(list.size()-1);
        }
    }
}