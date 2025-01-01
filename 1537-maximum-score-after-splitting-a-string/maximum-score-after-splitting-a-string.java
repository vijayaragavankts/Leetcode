class Solution {
    public int maxScore(String s) {
        int n = s.length();
        boolean isAllSame = true;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1) != s.charAt(i)){
                isAllSame = false;
            }
        }
        if(isAllSame){
            return n-1;
        }
        int[] zeros_in_left = new int[n];
        int[] ones_in_right = new int[n];

        int zero = 0;
        int one = 0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                zeros_in_left[i] = ++zero;
            }
            else{
                zeros_in_left[i] = zero;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                ones_in_right[i] = ++one;
            }
            else{
                ones_in_right[i] = one;
            }
        }
        
        int max = 0;
        for(int i=0;i<n-1;i++){
            int sum = zeros_in_left[i] + ones_in_right[i+1];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}