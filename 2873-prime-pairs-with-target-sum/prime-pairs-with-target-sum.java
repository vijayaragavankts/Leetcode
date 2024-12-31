

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();

        // Step 1: Generate a list of prime numbers using the Sieve of Eratosthenes
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Find all prime pairs
        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;
            if (isPrime[x] && isPrime[y]) {
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }

        return res;
    }
}