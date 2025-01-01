class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int m = s.length();
        int n = t.length();
        int[] numsOfS = new int[26];
        int[] numsOfT = new int[26];
        for(char ch:s.toCharArray()){
            numsOfS[ch - 'a']++;
        }
        for(char ch:t.toCharArray()){
            numsOfT[ch - 'a']++;
        }


        System.out.println(Arrays.toString(numsOfT));
        System.out.println(Arrays.toString(numsOfS));
        
        for(int i=0;i<26;i++){
            res += Math.abs(numsOfS[i] - numsOfT[i]);
        }


        return res;
        
    }
}