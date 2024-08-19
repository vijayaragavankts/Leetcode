class Solution {
    public int brokenCalc(int startValue, int target) {
        return f(startValue,target);
    }
    public int f(int i, int j){
        if(i >= j){
            return i - j;
        }
        if(j % 2 == 0){
            return 1 + f(i,j/2);
        }
        return 1 + f(i,j+1);
    }
}