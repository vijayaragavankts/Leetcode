class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxf = 0;
        int res = 0;
        int[] hash = new int[26];
        while(r < n){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            if(hash[ch-'A'] > maxf){
                maxf = hash[ch-'A'];
            }
            if((r-l+1) - maxf > k){
                // trim it from left side
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1) - maxf <= k){
                res = Math.max(res,(r-l+1));
            }
            r++;
        }
        return res;
    }
}