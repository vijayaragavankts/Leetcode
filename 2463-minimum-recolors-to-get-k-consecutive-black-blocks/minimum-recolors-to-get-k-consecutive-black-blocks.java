class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int l = 0;
        int r = k-1;
        int count_white = 0;
        int min = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            char ch = blocks.charAt(i);
            if(ch == 'W'){
                count_white++;
            }
        }
        if(count_white < min){
            min = count_white;
        }
        r++;
        while(r < n){
            char ch = blocks.charAt(r);
            if(ch == 'W'){
                count_white++;
            }
            if(blocks.charAt(l) == 'W'){
                count_white--;
            }
            r++;
            l++;
            if(count_white < min){
                min = count_white;
            }
        }
        return min;
    }
}