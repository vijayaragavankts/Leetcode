class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        int m = queries.length;
        int[] res = new int[m];
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for(int i=0;i<n;i++){
            if(nums[i] == x){
                list.add(i);
            }
        }
        for(int i=0;i<m;i++){
            int val = queries[i];
            if(val <= n && val < list.size()){
                res[i] = list.get(val);
            }
            else{
                res[i] = -1;
            }
        }
        return res;
    }
}