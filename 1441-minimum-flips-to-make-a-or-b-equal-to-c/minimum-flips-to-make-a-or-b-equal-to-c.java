class Solution {
    public int minFlips(int a, int b, int c) {
        String a1 = convertToBinary(a);
        String b1 = convertToBinary(b);
        String c1 = convertToBinary(c);
        System.out.println(a1 + " " + b1 + " " + c1);
        int a_len = a1.length();
        int b_len = b1.length();
        int c_len = c1.length();
        int max = Math.max(a_len,Math.max(b_len,c_len));
        while(a1.length() < max){
            a1 = "0" + a1;
        }
        while(b1.length() < max){
            b1 = "0" + b1;
        }
        while(c1.length() < max){
            c1 = "0" + c1;
        }
        System.out.println(a1 + " " + b1 + " " + c1);
        int res = 0;
        for(int i=a1.length()-1;i>=0;i--){
            int a_val = a1.charAt(i) - '0';
            int b_val = b1.charAt(i) - '0';
            int c_val = c1.charAt(i) - '0';
            if(a_val == 1 && b_val == 1 && c_val == 0){
                res += 2;
            }
            else if(a_val == 0 && b_val == 0 && c_val == 1){
                res++;
            }
            else if((a_val == 0 && b_val == 1 && c_val == 0) || (a_val == 1 && b_val == 0 && c_val == 0)){
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