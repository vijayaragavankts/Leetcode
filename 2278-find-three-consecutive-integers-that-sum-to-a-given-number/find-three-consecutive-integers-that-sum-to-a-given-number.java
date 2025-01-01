class Solution {
    public long[] sumOfThree(long num) {
        if(num % 3 != 0){
            return new long[]{};
        }
        long[] res = new long[3];
        long divide = num / 3;
        res[0] = divide-1;
        res[1] = divide;
        res[2] = divide+1;
        return res;
    }
}