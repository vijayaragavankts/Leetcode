class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] str = s.toCharArray();
        int l = 0;
        int r = n-1;
        while(l < r){
            if(set.contains(str[l]) && set.contains(str[r])){
                char ch = str[l];
                str[l] = str[r];
                str[r] = ch;
                l++;
                r--;
            }
            else if(set.contains(str[l])){
                r--;
            }
            else if(set.contains(str[r])){
                l++;
            }
            else{
                l++;
                r--;
            }
        }
        return new String(str);
    }
}