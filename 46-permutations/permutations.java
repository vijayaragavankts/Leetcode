class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums,new ArrayList(),res);
        return res;
    }
    public void f(int[] nums, List<Integer> list, List<List<Integer>> res){
        if(nums.length == list.size()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            f(nums,list,res);
            list.remove(list.size()-1);
        }
    }
}