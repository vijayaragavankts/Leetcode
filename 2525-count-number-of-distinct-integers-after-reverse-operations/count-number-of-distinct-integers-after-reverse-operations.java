class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        for(int val:nums){
            int temp = val;
            int reversed = 0;
            while(temp != 0){
                int mod = temp % 10;
                reversed = reversed * 10 + mod;
                temp = temp / 10;
            }
            set.add(reversed);
        }
        return set.size();
    }
}