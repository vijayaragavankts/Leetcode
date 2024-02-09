class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n+1];
        for(int i=1;i<=n;i++){
            nums[i-1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums,k,res,new ArrayList(),0);
        return res;
    }
    public void backtrack(int[] nums, int k , List<List<Integer>> res, List<Integer> list, int start){
        if(start >= nums.length){
            return;
        }
        if(list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        list.add(nums[start]);
        backtrack(nums,k,res,list,start+1);
        list.remove(list.size()-1);
        backtrack(nums,k,res,list,start+1);
    }
}