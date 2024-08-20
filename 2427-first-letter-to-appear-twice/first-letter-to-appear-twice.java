class Solution {
    public char repeatedCharacter(String s) {
        int[] letters = new int[26];
        for(char ch:s.toCharArray()){
            letters[ch-'a']++;
            if(letters[ch-'a'] == 2){
                return ch;
            }
        }
        return 'a';
    }
}