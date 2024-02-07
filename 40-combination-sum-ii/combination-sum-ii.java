class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates,target,res,new ArrayList(),0);
        return res;
    }
    public void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backtrack(nums,target-nums[i],res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}