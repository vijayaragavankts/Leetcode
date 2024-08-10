class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0){
            return true;
        }
        for(int i=1;i<=num;i++){
            StringBuilder sb = new StringBuilder();
            String val = i + "";
            sb.append(val);
            String rev = sb.reverse().toString();
            int forward = i;
            int backward = Integer.parseInt(rev);
            int res = forward + backward;
            if(res == num){
                return true;
            }
        }
        return false;
    }
}