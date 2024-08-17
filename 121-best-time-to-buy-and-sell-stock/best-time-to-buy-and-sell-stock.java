class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min_val = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(prices[i] < min_val){
                min_val = prices[i];
            }
            else if(prices[i] - min_val > result){
                result = prices[i] - min_val;
            }
        }
        return result;
    }
}