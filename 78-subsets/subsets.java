class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        calculate(nums,res,0,new ArrayList());
        return res;
    }
    public void calculate(int[] nums, List<List<Integer>> res, int start, List<Integer> list){
        res.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            calculate(nums,res,i+1,list);
            list.remove(list.size()-1);
        }
    }
}