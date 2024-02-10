class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        System.out.println(adj);
        int[] vis = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int current = queue.poll();
                    for(int j:adj.get(current)){
                        if(vis[j] == 0){
                            vis[j] = 1;
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}