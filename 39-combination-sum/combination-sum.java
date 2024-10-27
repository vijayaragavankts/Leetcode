class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        f(nums,target,new ArrayList(),0);
        return res;
    }
    public void f(int[] nums, int target, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            f(nums,target-nums[i],list,i);
            list.remove(list.size()-1);
        }
    }
}