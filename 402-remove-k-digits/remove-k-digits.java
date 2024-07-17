class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(num.length() == k){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for(char ch:num.toCharArray()){
            int val = ch - '0';
            while(!stack.isEmpty() && stack.peek() > val && k != 0){
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        String res = "";
        while(k != 0){
            stack.pop();
            k--;
        }
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}