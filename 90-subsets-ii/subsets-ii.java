class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums,0,new ArrayList(),res);
        return res;
    }
    public void f(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        if(!res.contains(list)){
            res.add(new ArrayList(list));
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            f(nums,i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}