class Solution {
    public int findCircleNum(int[][] isConnected) {
        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(adj,vis,i);
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> adj, boolean[] vis, int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        vis[node] = true;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int val:adj.get(temp)){
                if(!vis[val]){
                    stack.push(val);
                    vis[val] = true;
                }
            }
        }
    }
}