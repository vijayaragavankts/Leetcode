class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int n = heights.length;
        int max = 0;
        while(i < n){
            if(stack.isEmpty() || heights[i] > heights[stack.peek()]){
                stack.push(i);
                i++;
            }
            else{
                int x = stack.pop();
                int left = 0;
                int right = i;
                int area = Integer.MIN_VALUE;
                if(stack.isEmpty()){
                    area = heights[x] * right;
                }else{
                    left = stack.peek();
                    area = heights[x] * (right-left-1);
                }
                max = Math.max(max,area);
            }
        }
        while(!stack.isEmpty()){
            int x = stack.pop();
            int left = 0;
            int right = i;
            int area = Integer.MIN_VALUE;
            if(stack.isEmpty()){
                area = heights[x] * right;
            }else{
                left = stack.peek();
                area = heights[x] * (right-left-1);
            }
            max = Math.max(max,area);
        }
        return max;
    }
}