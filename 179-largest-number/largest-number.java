class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = nums[i] + "";
        }
        Comparator<String> com = new Comparator<String>(){
            public int compare(String s1, String s2){
                String res1 = s1 + s2;
                String res2 = s2 + s1;
                return res2.compareTo(res1);
            }
        };
        Arrays.sort(str,com);
        System.out.println(Arrays.toString(str));
        String res = "";
        int count = 0;
        for(String s:str){
            if(s.equals("0")){
                count++;
            }
            res += s;
        }
        if(count == str.length){
            return "0";
        }
        return res;
    }
}