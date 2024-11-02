class Solution {
    public String convertToTitle(int num) {
        String res = "";
        while(num != 0){
            num--;
            res = (char)((num % 26) + 'A') + res;
            num = num / 26;
        }
        return res;
    }
}