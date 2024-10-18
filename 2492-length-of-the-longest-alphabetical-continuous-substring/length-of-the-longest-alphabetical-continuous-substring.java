class Solution {
    public int longestContinuousSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        
        // Iterate through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // Check if the current character is consecutive to the previous one
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                currentLength++;
            } else {
                // Reset currentLength if it's not continuous
                currentLength = 1;
            }
            
            // Update maxLength if currentLength is larger
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}