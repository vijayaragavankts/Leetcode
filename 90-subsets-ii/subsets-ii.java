class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,res,new ArrayList(),0);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        // res.add(new ArrayList(list));
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