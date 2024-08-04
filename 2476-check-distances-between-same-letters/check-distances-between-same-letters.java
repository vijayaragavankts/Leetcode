class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(first[ch-'a'] == -1){
                first[ch-'a'] = i;
            }
            last[ch - 'a'] = i;
        }
        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(last));
        for(int i=0;i<26;i++){
            if(first[i] >= 0 && last[i] >= 0){
                int val = Math.abs(first[i] - last[i]) - 1;
                System.out.println(val + " " + distance[i]);
                if(val != distance[i]){
                    return false;
                }
            }
        }
        return true;
    }
}