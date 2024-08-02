class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;

        // Count the number of 1s in the array
        for (int num : nums) {
            countOnes += num;
        }

        if (countOnes == 0 || countOnes == n) {
            return 0;
        }

        int windowSize = countOnes;
        int minSwaps = Integer.MAX_VALUE;

        // Create an extended array to simulate the circular nature
        int[] extendedNums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extendedNums[i] = nums[i % n];
        }

        int zerosInWindow = 0;

        // Initialize the first window of size equal to the number of 1s
        for (int i = 0; i < windowSize; i++) {
            zerosInWindow += (1 - extendedNums[i]);
        }

        minSwaps = zerosInWindow;

        // Slide the window across the extended array and update the number of 0s in the window
        for (int i = windowSize; i < 2 * n; i++) {
            zerosInWindow += (1 - extendedNums[i]) - (1 - extendedNums[i - windowSize]);
            minSwaps = Math.min(minSwaps, zerosInWindow);
        }

        return minSwaps;
    }
}