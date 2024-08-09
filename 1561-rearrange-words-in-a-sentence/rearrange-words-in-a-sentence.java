class Solution {
    public String arrangeWords(String text) {
        List<String> list = new ArrayList<>();
        String[] str = text.split(" ");
        for(String s:str){
            list.add(s);
        }
        Comparator<String> com = new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Collections.sort(list,com);
        System.out.println(list);
        String res = "";
        for(String s:list){
            res += s + " ";
        }
        String temp = res.toLowerCase();
        String s = "";
        for(int i=0;i<temp.length();i++){
            char ch = temp.charAt(i);
            if(i == 0){
                if (ch >= 'a' && ch <= 'z') {
                    s += (char) (ch - 32) + "";
                }
            }else{
                s += ch + "";
            }
        }
        return s.trim();
    }
}