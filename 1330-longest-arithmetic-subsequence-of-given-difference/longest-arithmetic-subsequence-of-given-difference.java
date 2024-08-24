class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int val:arr){
            int temp = map.getOrDefault(val-diff,0);
            map.put(val,temp+1);
            res = Math.max(res,temp+1);
        }
        return res;
    }
}