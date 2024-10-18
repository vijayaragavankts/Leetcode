class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int res = 1;
        int current = 1;
        for(int i=1;i<n;i++){
            if(s.charAt(i) - s.charAt(i-1) == 1){
                current++;
            }
            else{
                current = 1;
            }
            res = Math.max(res,current);
        }
        return res;
    }
}