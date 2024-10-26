class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        f(nums,target,0, new ArrayList(),0);
        return res;
    }
    public void f(int[] nums, int target, int current, List<Integer> list,int start){
        if(current > target){
            return;
        }
        if(current == target){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            f(nums,target,current+nums[i],list,i);
            list.remove(list.size()-1);
        }
    }
}