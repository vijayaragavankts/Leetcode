class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            else{
                res++;
            }
        }
        return res + stack.size();
    }
}