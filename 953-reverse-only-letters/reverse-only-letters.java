class Solution {
    public String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int l = 0;
        int r = n-1;
        while(l < r){
            if(Character.isLetter(str[l]) && Character.isLetter(str[r])){
                char ch = str[l];
                str[l] = str[r];
                str[r] = ch;
                l++;
                r--;
            }
            else if(!Character.isLetter(str[l])){
                l++;
            }
            else{
                r--;
            }
        }
        return new String(str);
    }
}