class Solution {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        String[] str = trimmed.split(" ");
        return str[str.length - 1].length();
    }
}