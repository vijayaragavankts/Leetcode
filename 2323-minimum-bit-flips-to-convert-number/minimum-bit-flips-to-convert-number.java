class Solution {
    public int minBitFlips(int start, int goal) {
        String a = convertToBinary(start);
        String b = convertToBinary(goal);
        System.out.println(a + " " + b);
        int res = 0;
        int count = 0;
        if(a.length() < b.length()){
            int addLeadingZero = b.length() - a.length();
            for(int i=0;i<addLeadingZero;i++){
                a = "0" + a;
            }
        }
        else if(b.length() < a.length()){
            int addLeadingZero = a.length() - b.length();
            for(int i=0;i<addLeadingZero;i++){
                b = "0" + b;
            }
        }

            for(int i=a.length()-1;i>=0;i--){
                if(a.charAt(i) != b.charAt(i)){
                    res++;
                }
            }
        
        
        return res;
    }
    public String convertToBinary(int num){
        String res = "";
        while(num != 0){
            res = (num % 2) + res;
            num = num / 2;
        }
        return res;
    }
}