class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int n = nums.length;
        for(int val:nums){
            if(val >= 0){
                positive.add(val);
            }
            else{
                negative.add(val);
            }
        }
        int[] res = new int[n];
        int x = 0;
        int y = 0;
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                res[i] = positive.get(x++);
            }
            else{
                res[i] = negative.get(y++);
            }
        }
        return res;
    }
}