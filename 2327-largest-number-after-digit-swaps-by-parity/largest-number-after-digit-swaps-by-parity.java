class Solution {
    public int largestInteger(int num) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int temp = num;
        while(temp != 0){
            int last = temp % 10;
            if(last % 2 == 1){
                odd.add(last);
            }else{
                even.add(last);
            }
            temp = temp / 10;
        }
        Collections.sort(odd,Collections.reverseOrder());
        Collections.sort(even,Collections.reverseOrder());

        String s = num + "";
        int res = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i) - '0';
            if(val % 2 == 0){
                res = res * 10;
                res += even.get(x++);
            }
            else{
                res = res * 10;
                res += odd.get(y++);
            }
        }
        return res;
    }
}