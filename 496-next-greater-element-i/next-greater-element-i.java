class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            int val = nums2[i];
            if(stack.isEmpty()){
                stack.push(val);
                map.put(nums2[i],-1);
            }
            else if(val < stack.peek()){
                map.put(nums2[i],stack.peek());
                stack.push(val);
            }
            else if(val > stack.peek()){
                while(!stack.isEmpty()){
                    if(val < stack.peek()){
                        break;
                    }
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(nums2[i],-1);
                }
                else{
                    map.put(nums2[i],stack.peek());
                }
                stack.push(val);
            }
        }

        int m = nums1.length;
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}