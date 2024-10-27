class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        f(nums,k,target,new ArrayList(),0,0);
        return res;
    }
    public void f(int[] nums, int k,int target,List<Integer> list, int start, int current){
        if(current > target){
            return;
        }
        if(current == target && list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            f(nums,k,target,list,i+1,current+nums[i]);
            list.remove(list.size()-1);
        }

    }
}