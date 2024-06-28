class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // bfs
        // graph coloring problem
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                // bfs call
                if(dfs(i,adj,color,0) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> adj, int[] color,int key){
        int n = adj.size();
        color[node] = key;
        for(int val:adj.get(node)){
            if(color[val] == -1){
                if(dfs(val,adj,color,1-key) == false){
                    return false;
                }
            }
            if(color[val] == color[node]){
                return false;
            }
        }
        return true;
    }
}