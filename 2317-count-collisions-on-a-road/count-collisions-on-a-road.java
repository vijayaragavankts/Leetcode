class Solution {
    public int countCollisions(String s) {
        // the question is asking 
        // how much no leading l and no trailing r and no s

        int n = s.length();
        int count_leading_L = 0;
        int count_trailing_R = 0;
        int count_S = 0;
        for(char ch:s.toCharArray()){
            if(ch == 'L'){
                count_leading_L++;
            }else{
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == 'R'){
                count_trailing_R++;
            }
            else{
                break;
            }
        }
        for(char ch:s.toCharArray()){
            if(ch == 'S'){
                count_S++;
            }
        }
        int res = n - count_leading_L - count_trailing_R - count_S;
        return res;
    }
}