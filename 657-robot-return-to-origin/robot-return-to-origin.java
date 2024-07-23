class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.length() % 2 != 0){
            return false;
        }
        int[] arr = new int[255];
        arr['D' - '0'] = -1;
        arr['U' - '0'] = +1;
        arr['L' - '0'] = -2;
        arr['R' - '0'] = +2;
        int sum1 = 0;
        int sum2 = 0;
        for(char ch:moves.toCharArray()){
            if(ch == 'L' || ch == 'R'){
                sum1 += arr[ch-'0'];
            }
            else{
                sum2 += arr[ch-'0'];
            }
            
        }
        return sum1 == 0 && sum2 == 0 ? true : false;
    }
}