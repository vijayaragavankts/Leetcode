class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] ref = new int[n];
        int[] res = new int[m];


        for(int i=0;i<n;i++){
            int last = words[i].length()-1;
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(last))){
                ref[i] = 1;
            }
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = ref[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + ref[i];
        }
        for(int i=0;i<m;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start > 0){
                res[i] = prefixSum[end] - prefixSum[start-1];
            }
            else{
                res[i] = prefixSum[end];
            }
        }
        return res;
    }
}