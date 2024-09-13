class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        System.out.println(1 ^ 3);
        int[] resArr = new int[n];
        for(int i=0;i<n;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int res = 0;
            for(int j=start;j<=end;j++){
                res = res ^ arr[j];
            }
            resArr[i] = res;
        }
        
        return resArr;
    }
}