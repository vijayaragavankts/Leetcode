class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
            }
            else if(s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b-a);
            }
            else if(s.equals("*")){
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
            }
            else if(s.equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            }
            else{
                int val = Integer.parseInt(s);
                stack.push(val);
            }
        }
        // System.out.println(stack);
        return stack.pop();
    }
    
}