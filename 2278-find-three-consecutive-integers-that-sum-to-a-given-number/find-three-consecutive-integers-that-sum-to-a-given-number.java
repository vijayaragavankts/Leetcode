class Solution {
    public long[] sumOfThree(long num) {
        long[] res = new long[3];
        if(num % 3 != 0){
            return new long[]{};
        }
        long divide = num / 3;
        res[0] = divide-1;
        res[1] = divide;
        res[2] = divide+1;
        return res;
    }
}