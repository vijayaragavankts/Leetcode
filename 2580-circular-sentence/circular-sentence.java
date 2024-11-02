class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split(" ");
        char super_start = str[0].charAt(0);
        char start = str[0].charAt(0);
        char end = str[0].charAt(str[0].length()-1);
        for(int i=1;i<str.length;i++){
            String s = str[i];
            if(end != s.charAt(0)){
                return false;
            }
            end = s.charAt(s.length()-1);
        }
        if(super_start != end){
            return false;
        }
        return true;
    }
}