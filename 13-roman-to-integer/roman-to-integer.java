class Solution {
    public int romanToInt(String s) {
        int[] letter = new int[255];
        letter['I'-'0'] = 1;
        letter['V'-'0'] = 5;
        letter['X'-'0'] = 10;
        letter['L'-'0'] = 50;
        letter['C'-'0'] = 100;
        letter['D'-'0'] = 500;
        letter['M'-'0'] = 1000;

        int res = 0;
        int n = s.length();
        for(int i=1;i<n;i++){
            char ch = s.charAt(i-1);
            char ch2 = s.charAt(i);
            if(letter[ch-'0'] >= letter[ch2-'0']){
                res += letter[ch-'0'];
            }
            else if(letter[ch-'0'] < letter[ch2-'0']){
                res -= letter[ch-'0'];
            }
            
        }
        res += letter[s.charAt(n-1)-'0'];
    
        return res;
    }
}