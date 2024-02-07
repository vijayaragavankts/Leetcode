class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        backtrack(candidates,res,target,new ArrayList(),0);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, int target, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,res,target-nums[i],list,i);
            list.remove(list.size()-1);
        }
    }
}