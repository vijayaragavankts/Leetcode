class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min = Math.min(min,matrix[i][j]);
            }
            set1.add(min);
        }
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                max = Math.max(max,matrix[j][i]);
            }
            set2.add(max);
        }
        List<Integer> list = new ArrayList<>();
        for(int val:set1){
            if(set2.contains(val)){
                list.add(val);
            }
        }
        return list;
    }
}