class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countA = 0;
        int countB = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            b[i] = countB;
            if(s.charAt(i) == 'b'){
                countB++;
            }
        }
        for(int i=n-1;i>=0;i--){
            a[i] = countA;
            if(s.charAt(i) == 'a'){
                countA++;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res,a[i] + b[i]);
        }
        return res;
    }
}