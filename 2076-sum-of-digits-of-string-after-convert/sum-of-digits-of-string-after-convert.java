class Solution {
    public int getLucky(String s, int k) {
        
        int n = s.length();
        String temp = "";
        for(char ch:s.toCharArray()){
            temp += (int)( ch - 'a' + 1);
        }
        System.out.println(temp);
        
        int sum = 0;
        while(k-- > 0){
            for(char ch:temp.toCharArray()){
                
                sum += (int)(ch-'0');
                System.out.println(sum);
            }
            // System.out.println(sum);
            temp = sum + "";
            sum = 0;
        }
        // System.out.println(temp);
        return Integer.parseInt(temp);
    }
}