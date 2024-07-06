class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] nums = new int[3];
        int res = 0;
        Arrays.fill(nums,-1);
        for(int i=0;i<n;i++){
            nums[s.charAt(i)-'a'] = i;
            if(nums[0] != -1 && nums[1] != -1 && nums[2] != -1){
                res += 1 + (Math.min(nums[0],Math.min(nums[1],nums[2])));
            }
        }
        return res;
    }
}