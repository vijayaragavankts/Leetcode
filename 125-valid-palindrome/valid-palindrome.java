class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                sb.append(c);
            }
        }
        String str = sb.toString().toLowerCase();
        int l = 0;
        int r = str.length() - 1;
        while(l <= r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}