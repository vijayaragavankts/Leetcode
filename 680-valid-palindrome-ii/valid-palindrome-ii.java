class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        int k = 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r) && k == 0){
                return false;
            }
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else if(s.charAt(l) != s.charAt(r) && k == 1){
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}