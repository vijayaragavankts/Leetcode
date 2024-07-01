class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            map.put(chars.charAt(i),vals[i]);
        }
        int n = s.length();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                arr[i] = map.get(ch);
            }
            else{
                arr[i] = ch - 96;
            }
        }
        // kadane's method
        int sum = 0;
        int max = Integer.MIN_VALUE;;
        for(int val:arr){
            sum += val;
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max > 0 ? max : 0;
    }
}