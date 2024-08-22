class Solution {
    public int findComplement(int num) {
        String res = "";
        while(num != 0){
            String s = num % 2 + "";
            res = s + res;
            num = num / 2;
        }
        System.out.println(res);
        String result = "";
        for(char ch:res.toCharArray()){
            if(ch == '0'){
                result += "1";
            }
            else{
                result += "0";
            }
        }
        int size = result.length();
        int val = 0;
        int y = 0;
        for(int i=size-1;i>=0;i--){
            int x = result.charAt(i) - '0';
            val += x * Math.pow(2,y++);
        }
        return val;
    }
}