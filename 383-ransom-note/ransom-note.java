class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(char ch:ransomNote.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:magazine.toCharArray()){
            if(freq[ch-'a'] > 0){
                freq[ch-'a']--;
            }
        }
        for(int val:freq){
            if(val > 0){
                return false;
            }
        }
        return true;
    }
}