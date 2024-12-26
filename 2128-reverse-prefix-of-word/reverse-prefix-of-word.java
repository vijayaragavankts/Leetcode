class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int l = 0;
        int r = 0;
        char[] str = word.toCharArray();
        while(r < n){
            if(str[r] == ch){
                // do reverse
                for(int i=0;i<=r/2;i++){
                    char temp = str[i];
                    str[i] = str[r-i];
                    str[r-i] = temp;
                }
                break;
            }
            else{
                r++;
            }
        }
        return new String(str);
    }
}