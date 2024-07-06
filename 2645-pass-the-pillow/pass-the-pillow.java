class Solution {
    public int passThePillow(int n, int time) {
        if(time < n){
            return time+1;
        }
        else if(time == n){
            return n-1;
        }
        // n-1 times la completes 1 direction
        // and then have to subtract
        int div = time / (n-1);
        int rem = time % (n-1);

        if (rem == 0) {
            if (div % 2 == 0) {
                return 1; // Returns to the first person if even division
            } else {
                return n; // Returns to the last person if odd division
            }
        } 
        else {
            if (div % 2 == 0) {
                return 1 + rem; // Move forward if even division
            } else {
                return n - rem; // Move backward if odd division
            }
        }
    }
}