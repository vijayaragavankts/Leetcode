class Solution {
    public int[] decrypt(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        if(k == 0){
            Arrays.fill(res,0);
            return res;
        }
        else if(k > 0){
            for(int i=0;i<nums.length;i++){
                int sum = 0;
                for(int j=0;j<k;j++){
                    sum += nums[(i + j + 1)%n];
                }
                res[i] = sum;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                int sum = 0;
                int abs = Math.abs(k);
                for (int j = 1; j <= abs; j++) {
                    sum += nums[(i - j + n) % n];
                }
                res[i] = sum;
            }
        }
        return res;
    }
}