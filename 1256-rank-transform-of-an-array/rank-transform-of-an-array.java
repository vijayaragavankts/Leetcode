class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = arr.clone();
        Arrays.sort(arr);
        int iter = 1;
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],iter++);
            }
        }
        

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(result[i]);
        }
        return arr;
    }
}