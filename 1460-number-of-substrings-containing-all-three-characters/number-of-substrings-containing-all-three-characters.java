class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.getOrDefault('a', 0) > 0 && map.getOrDefault('b', 0) > 0 && map.getOrDefault('c', 0) > 0) {
                res += n - r; // all substrings ending at or after r are valid
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
        }

        return res;
    }
}