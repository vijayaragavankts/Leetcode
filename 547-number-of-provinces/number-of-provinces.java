class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i,visited,adj);
                count++;
            }
        }
        
        return count;
    }
    public void bfs(int node, int[] visited, List<List<Integer>> adj, Queue<Integer> queue){
        visited[node] = 1;
        queue.offer(node);

        while(!queue.isEmpty()){
            int val = queue.poll();
            for(int element:adj.get(val)){
                if(visited[element] == 0){
                    queue.offer(element);
                    visited[element] = 1;
                }
            }
        }
    }

    public void dfs(int node, int[] visited, List<List<Integer>> adj){
        visited[node] = 1;
        for(int val:adj.get(node)){
            if(visited[val] == 0){
                dfs(val,visited,adj);
            }
        }
    }
}