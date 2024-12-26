class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        int res = 0;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return r-l+1;
            }
            if(s.charAt(l) == s.charAt(r)){
                char glory = s.charAt(l);
                while(l <= r){
                    if(s.charAt(l) == glory){
                        l++;
                    }
                    else{
                        break;
                    }
                }
                while(r >= l){
                    if(s.charAt(r) == glory){
                        r--;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return r-l+1;
    }
}