class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = s.length();
        int l = 0;
        int r = k-1;
        int max = 0;
        int count = 0;

        for(int i=l;i<=r;i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count++;
            }
        }
        max = count;
        r++;
        while(r < n){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                count++;
            }
            char ch2 = s.charAt(l);
            if(set.contains(ch2)){
                count--;
            }
            l++;
            r++;
            if(count > max){
                max = count;
            }
        }
        return max;
    }
}