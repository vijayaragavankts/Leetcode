class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int p = 0;
        int res = 0;
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            res += (ch - 'A' + 1) * Math.pow(26,p++);
        }
        return res;
    }
}