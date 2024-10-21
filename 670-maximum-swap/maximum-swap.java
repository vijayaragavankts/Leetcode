class Solution {
    public int maximumSwap(int num) {
        // Step 1: Convert the number to a char array
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        // Step 2: Create an array to store the last occurrence of each digit
        int[] last = new int[10];  // To store positions of digits 0-9
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;  // Store the last occurrence of the digit
        }
        
        // Step 3: Try to find a swap that maximizes the number
        for (int i = 0; i < n; i++) {
            // For the current digit, check if there's a larger digit later
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {  // There's a larger digit later in the number
                    // Swap the current digit with the larger one
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    // Convert the result back to an integer and return
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap is done, return the original number
        return num;
    }
}
