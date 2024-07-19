class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[255];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        System.out.println(map);
        int l = 0;
        int r = 0;
        int minStart = 0;
        int counter = t.length();
        int minLen = Integer.MAX_VALUE;
        while(r < s.length()){
            char c = s.charAt(r);
            if(map[c] > 0){
                counter--;
            }
            map[c]--;
            r++;
            while(counter == 0){
                if(minLen > r-l){
                    minLen = r-l;
                    minStart = l;
                }
                char ch = s.charAt(l);
                map[ch]++;
                l++;
                if(map[ch] > 0){
                    counter++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart + minLen);
    }
}