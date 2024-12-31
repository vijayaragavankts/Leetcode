class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(gcd(i,j) == 1){
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }
    public int gcd(int i, int j){
        while(j != 0){
            int temp = j;
            j = i % j;
            i = temp;
        }
        return i;
    }
}