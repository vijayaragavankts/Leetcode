class Solution {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,n);
        }
        return res;
    }
    public void dfs(int curr,int n){
        if(curr > n){
            return;
        }
        res.add(curr);
        for(int i=0;i<=9;i++){
            if(curr*10 + i > n){
                break;
            }
            dfs(curr*10 + i,n);
        }
    }
}