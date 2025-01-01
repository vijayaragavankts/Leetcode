class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int m = s.length();
        int n = t.length();
        int[] nums = new int[26];
        for(char ch:s.toCharArray()){
            nums[ch - 'a']++;
        }
        for(char ch:t.toCharArray()){
            nums[ch - 'a']--;
        }
        
        for(int i=0;i<26;i++){
            res += Math.abs(nums[i]);
        }


        return res;
        
    }
}