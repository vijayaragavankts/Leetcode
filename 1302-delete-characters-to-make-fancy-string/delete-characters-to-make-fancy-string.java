class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            char last = s.charAt(i-1);
            if(ch == last){
                count++;
            }
            else{
                count = 1;
            }
            if(count < 3){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}