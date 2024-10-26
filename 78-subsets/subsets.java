class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums,0,new ArrayList(),res);
        return res;
    }
    public void f(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            f(nums,i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}