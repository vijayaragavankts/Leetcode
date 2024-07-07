class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int l = 0;
        int r = 0;
        int res = 0;
        int maxf = 0;
        int[] hash = new int[26];
        while(r < n){
            char ch = answerKey.charAt(r);
            hash[ch-'A']++;
            if(hash[ch-'A'] > maxf){
                maxf = hash[ch-'A'];
            }
            if((r-l+1) - maxf > k){
                hash[answerKey.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1) - maxf <= k){
                // valid condition
                res = Math.max(res,(r-l+1));
            }
            r++;
        }
        return res;
    }
}