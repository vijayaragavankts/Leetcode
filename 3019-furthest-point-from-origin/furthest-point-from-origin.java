class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        if(moves.length() == 1){
            return 1;
        }
        int maxii = Integer.MIN_VALUE;
        // try out all blanks with L
        int count1 = 0;
        for(char ch:moves.toCharArray()){
            if(ch == 'L' || ch == '_'){
                count1++;
            }
            else{
                count1--;
            }
        }
        maxii = Math.max(maxii,count1);
        // try out all blanks with R
        int count2 = 0;
        for(char ch:moves.toCharArray()){
            if(ch == 'R' || ch == '_'){
                count2++;
            }
            else{
                count2--;
            }
        }
        maxii = Math.max(maxii,count2);
        return maxii;
    }
}