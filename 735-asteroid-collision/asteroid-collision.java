class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val >= 0){
                stack.push(val);
            }
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(val)){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == Math.abs(val)){
                    stack.pop();
                }
                else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(val);
                }
            }
        }

        int size = stack.size();
        int[] arr = new int[size];

        for(int i=size-1;i>=0;i--){
            arr[i] = stack.pop();
        }
        
        return arr;
    }
}