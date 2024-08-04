class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int n = nums.length;
        for(int val:nums){
            if(val % 2 == 1){
                odd.add(val);
            }
            else{
                even.add(val);
            }
        }
        int[] res = new int[n];
        int x = 0;
        int y = 0;
        for(int i=0;i<n;i++){
            if(i % 2 == 1){
                res[i] = odd.get(x++);
            }
            else{
                res[i] = even.get(y++);
            }
        }
        return res;
    }
}