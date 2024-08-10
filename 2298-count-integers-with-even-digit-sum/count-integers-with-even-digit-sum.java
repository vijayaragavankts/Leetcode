class Solution {
    public int countEven(int num) {
        int res = 0;
        for(int i=1;i<=num;i++){
            int val = i;
            int sum = 0;
            while(val != 0){
                sum += val % 10;
                val = val / 10;
            }
            if(sum % 2 == 0){
                res++;
            }
        }
        return res;
    }
}