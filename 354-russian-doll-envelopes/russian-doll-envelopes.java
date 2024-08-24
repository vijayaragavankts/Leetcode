// class Solution {
//     int[][] dp;
//     public int maxEnvelopes(int[][] pairs) {
//         Arrays.sort(pairs,(a,b)->{
//             int val = Integer.compare(a[0],b[0]);
//             if(val != 0){
//                 return val;
//             }
//             return Integer.compare(a[1],b[1]);
//         });
//         int m = pairs.length;
//         dp = new int[m+1][m+1];
//         for(int[] arr:dp){
//             Arrays.fill(arr,-1);
//         }
//         return f(pairs,0,-1,m);
//     }
//     int f(int[][] nums, int i, int j, int m){
//         // base case
//         if(i == m){
//             return 0;
//         }
//         if(dp[i+1][j+1] != -1){
//             return dp[i+1][j+1];
//         }

//         int notTake = f(nums,i+1,j,m);
//         int take = 0;
//         if(j == -1 || (nums[i][0] > nums[j][0] && nums[i][1] > nums[j][1])){
//             take = 1 + f(nums,i+1,i,m);
//         }
//         return dp[i+1][j+1] = Math.max(take,notTake);
//     }
// }


class Solution {
    /**
    This is a classic LIS problem. Trick is to sort the envelopes by increasing width first
    then decreasing height. Post that, this becomes longest increasing subsequence problem
    where we check which envelope can take in most of envelopes.
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] != envelope2[0])
                    return Integer.compare(envelope1[0], envelope2[0]);
                else 
                    return Integer.compare(envelope2[1], envelope1[1]);
            }
        });

        // for (int i = 0; i < envelopes.length; i++) {
        //     System.out.println(envelopes[i][0] + " " + envelopes[i][1]);
        // }

        // LIS is perfomed on heights of envelope here using Binary search instead of regular one using DP
        // we have a list of heights of envelopes that keep on expanding or getting altered based on incoming
        // element.
        
        List<Integer> currentLIS = new ArrayList<>();
        currentLIS.add(envelopes[0][1]);
        int ans = 0;
        for (int i = 1; i < envelopes.length; i++) {
            if (currentLIS.get(currentLIS.size() - 1) < envelopes[i][1]) {
                currentLIS.add(envelopes[i][1]);
            } else {
                int correctIndex = findPosition(currentLIS, envelopes[i][1]);
                currentLIS.set(correctIndex, envelopes[i][1]);
            }
        }

        ans = currentLIS.size();

        return ans;

        // int[] LIS = new int[envelopes.length];
        // int ans = 0;
        // Arrays.fill(LIS, 1);

        // for (int i = envelopes.length - 1; i >= 0; i--) {
        //     for (int j = i + 1; j < envelopes.length; j++) {
        //         // if (envelopes[i][0] < envelopes[j][0] &&  envelopes[i][1] < envelopes[j][1]) {
                

        //         // no need to check for greater than width part because its pre-sorted acc to width.
        //         // for same width, its reverse sorted by height so below condition will also fail.
        //         if (envelopes[i][1] < envelopes[j][1]) {
        //             LIS[i] = Math.max(LIS[i], LIS[j] + 1);
        //         }
        //     }
        //     ans = Math.max(ans, LIS[i]);
        // }

        // return ans;
    }

    private int findPosition(List<Integer> currentLIS, int value) {
        int low = 0;
        int high = currentLIS.size() - 1;
        int mid, ans = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (currentLIS.get(mid) >= value) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}