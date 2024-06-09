class Solution {
    public int minInsertions(String s) {
        s = s.replace("))","}");
        System.out.println(s);
        int invalid = 0;
        int stack = 0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                stack++;
            }
            else{
                if(ch == ')'){
                    invalid++;
                }
                if(stack>0){
                    stack--;
                }
                else{
                    invalid++;
                }
            }
            
        }
        return invalid + (stack * 2) ;
    }
}