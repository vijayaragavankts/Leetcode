class Solution {
    public String finalString(String s) {
        int n = s.length();
        int i_count = 0;
        for(char ch:s.toCharArray()){
            if(ch == 'i'){
                i_count++;
            }
        }
        char[] str = new char[n-i_count];
        int x = 0;
        for(char ch:s.toCharArray()){
            if(ch == 'i'){
                int l = 0;
                int r = x-1;
                while(l < r){
                    char temp = str[l];
                    str[l] = str[r];
                    str[r] = temp;
                    l++;
                    r--;
                }
            }
            else{
                str[x++] = ch;
            }
        }
        return new String(str);
    }
}