class Solution {
    public String sortVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        List<Character> list = new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                list.add(ch);
            }
        }
        Collections.sort(list);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                sb.append(list.get(i++));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}