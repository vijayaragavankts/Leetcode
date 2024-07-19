class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            if(!queue.isEmpty() && queue.peek() == i-k){
                queue.poll();
            }
            queue.offer(i);
            if(i >= k-1){
                list.add(queue.peek());
            }
        }
        int size = list.size();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = nums[list.get(i)];
        }
        return arr;
    }
}