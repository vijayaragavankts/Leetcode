class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(nums,res,0,new ArrayList());
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, int start, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(nums,res,i,list);
            list.remove(list.size()-1);
        }
    }
}