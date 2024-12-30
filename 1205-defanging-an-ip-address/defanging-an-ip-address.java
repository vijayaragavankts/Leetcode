class Solution {
    public String defangIPaddr(String address) {
        int n = address.length();
        Queue<Character> queue = new LinkedList<>();
        for(char ch:address.toCharArray()){
            if(ch == '.'){
                queue.offer('[');
                queue.offer('.');
                queue.offer(']');
            }
            else{
                queue.offer(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}