class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++){
            stack.push(i+1);
            if(i == n || pattern.charAt(i) == 'I'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();
    }
}