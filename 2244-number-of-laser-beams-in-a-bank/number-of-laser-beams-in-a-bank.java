class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int res = 0;
        int prev = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            String str = bank[i];
            for(char ch:str.toCharArray()){
                if(ch == '1'){
                    count++;
                }
            }
            if(count == 0){
                continue;
            }
            res += count * prev;
            prev = count;
        }
        return res;
    }
}