class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList();
        f(s,new StringBuilder(),res,0);
        return res;
    }
    public void f(String s, StringBuilder sb, List<String> res,int i){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }

            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                sb.append(ch);
                f(s,sb,res,i+1);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(Character.toLowerCase(ch));
                f(s,sb,res,i+1);
                sb.deleteCharAt(sb.length()-1);
                sb.append(Character.toUpperCase(ch));
                f(s,sb,res,i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        
    }
}