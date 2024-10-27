// class Solution {
//     private int res = 0;
//     public int combinationSum4(int[] nums, int target) {
//         f(nums,target,new ArrayList(),0);
//         return res;
//     }
//     public void f(int[] nums, int target, List<Integer> list, int current){
//         if(current > target){
//             return;
//         }
//         if(current == target){
//             res += 1;
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             list.add(nums[i]);
//             f(nums,target,list,current+nums[i]);
//             list.remove(list.size()-1);
//         }
//     }
// }

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}