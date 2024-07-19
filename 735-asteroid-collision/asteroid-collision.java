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

        while(!stack.isEmpty()){
            int val = stack.pop();
            list.add(0,val);
        }
        System.out.println(list);
        int size = list.size();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}