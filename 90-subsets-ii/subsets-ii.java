class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        Arrays.sort(nums);
        backtrack(nums,result,new ArrayList(),0);
        return result;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        if(!res.contains(list)){
            res.add(new ArrayList(list));
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}