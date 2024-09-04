class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char first = coordinate1.charAt(0);
        char second = coordinate2.charAt(0);
        int num1 = coordinate1.charAt(1);
        int num2 = coordinate2.charAt(1);

        if((first - 'a' + second - 'a') % 2 == 0 && (num1 + num2) % 2 == 0){
            return true;
        }
        else if((first - 'a' + second - 'a') % 2 == 1 && (num1 + num2) % 2 == 1){
            return true;
        }
        return false;
    }
}