class Solution {
    public int repeatedStringMatch(String a, String b) {
        int x = a.length();
        int y = b.length();
        int n = (int)(Math.ceil((double)y / x));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(a);
        }
        if(sb.toString().contains(b)){
            return n;
        }
        if((sb.toString() + a).contains(b) ){
            return n+1;
        }
        return -1;
    }
}