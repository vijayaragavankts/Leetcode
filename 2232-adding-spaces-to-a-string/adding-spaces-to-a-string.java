class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int val:spaces){
            set.add(val);
        }
        for(int i=0;i<s.length();i++){
            if(set.contains(i)){
                sb.append(" ");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}