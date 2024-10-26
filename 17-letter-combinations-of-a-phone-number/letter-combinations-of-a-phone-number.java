class Solution {
    String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        f(digits,"",0,res);
        return res;
    }
    public void f(String digits, String current, int idx, List<String> res){
        if(idx == digits.length()){
            res.add(current);
            return;
        }
        String letters = str[digits.charAt(idx)-'0'];
        for(char ch:letters.toCharArray()){
            f(digits,current+ch,idx+1,res);
        }
    }
}