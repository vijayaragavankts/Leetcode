class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(String s:details){
            int first = s.charAt(11)-'0';
            int second = s.charAt(12)-'0';
            list.add((first * 10) + second);
        }
        for(int val:list){
            if(val > 60){
                res++;
            }
        }
        return res;
    }
}