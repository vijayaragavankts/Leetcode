class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] arr = new int[n+1];
        int min = 0;
        int max = n;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'I'){
                arr[i] = min++;
            }
            else{
                arr[i] = max--;
            }
        }
        arr[n] = max;
        return arr;
    }
}