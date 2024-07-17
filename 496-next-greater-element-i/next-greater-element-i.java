class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            int val = nums2[i];
            while(!stack.isEmpty() && stack.peek() <= val){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(val,-1);
            }else{
                map.put(val,stack.peek());
            }
            stack.push(val);
        }

        int m = nums1.length;
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}