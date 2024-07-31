class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        int[] arr = new int[26];
        arr['a'-'a']++;
        arr['e'-'a']++;
        arr['i'-'a']++;
        arr['o'-'a']++;
        arr['u'-'a']++;
        for(int i=left;i<=right;i++){
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length()-1);
            if(arr[start-'a'] == 1 && arr[end-'a'] == 1){
                res++;
            }else{

            }
        }
        return res;
    }
}