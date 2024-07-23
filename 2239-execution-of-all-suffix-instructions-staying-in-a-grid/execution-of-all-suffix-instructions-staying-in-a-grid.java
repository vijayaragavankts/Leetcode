class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int r = startPos[0];
        int c = startPos[1];
        int size = s.length();
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            char ch = s.charAt(i); // R
            int val = f(n,r,c,i,s,true);
            res[i] = val;
        }
        return res;
    }
    public int f(int n, int i, int j, int ind, String s,boolean flag){
        
        if(ind >= s.length()){
            return 0;
        }

        
        char ch = s.charAt(ind);
        
            
        if(ch == 'L'){
            if(!isPossible(i,j-1,n)){
                return 0;
            }
            
            return 1 + f(n,i,j-1,ind+1,s,flag);
        }
        if(ch == 'R'){
            if(!isPossible(i,j+1,n)){
                return 0;
            }
            return 1 + f(n,i,j+1,ind+1,s,flag);
        }
        if(ch == 'U'){
            if(!isPossible(i-1,j,n)){
                return 0;
            }
            return 1 +f(n,i-1,j,ind+1,s,flag);
        }
        else{
            if(!isPossible(i+1,j,n)){
                return 0;
            }
            return 1 + f(n,i+1,j,ind+1,s,flag);
        }
        
    }
    public boolean isPossible(int row,int col,int n)
    {
        if(row>=n || col>=n || row<0 || col<0)
        return false;
        
        return true;
    }
}