class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // flatten the 2D matrix to 1D Array
        int[] nums = new int[n*n+1];
        boolean flag = true;
        int idx = 1;
        for(int i=n-1;i>=0;i--){
            if(flag){
                for(int j=0;j<n;j++){
                    nums[idx++] = board[i][j];
                }
            }
            else{
                for(int j=n-1;j>=0;j--){
                    nums[idx++] = board[i][j];
                }
            }
            flag = !flag;
            
        }
        int[] vis = new int[n*n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int curr = queue.peek();
                queue.poll();
                if(curr == n * n){
                    return result;
                }
                for(int dice=1;dice<=6;dice++){
                    int next = dice + curr;
                    if(next > n*n){
                        break;
                    }
                    if(nums[next] != -1){
                        next = nums[next];
                    }
                    if(vis[next] == 0){
                        vis[next] = 1;
                        queue.offer(next);
                    }

                }
            }
            result++;
        }

        return -1;
    }
}