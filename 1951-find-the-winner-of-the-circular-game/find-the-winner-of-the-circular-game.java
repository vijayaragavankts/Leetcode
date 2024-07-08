class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 1;
        while(i<=n){
            queue.offer(i);
            i++;
        }
        while(queue.size() != 1 ){
            int x = 1;
            while(x < k){
                int val = queue.peek();
                queue.offer(val);
                queue.poll();
                x++;
            }
            queue.poll();
        }
        return queue.peek();
    }
}