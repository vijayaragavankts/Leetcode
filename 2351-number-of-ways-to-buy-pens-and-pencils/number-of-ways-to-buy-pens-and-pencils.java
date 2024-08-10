class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int pen_cost = 0;
        while(pen_cost <= total){
            int rem = total - pen_cost;
            int val = (rem / cost2) + 1;
            res += val;
            pen_cost += cost1;
        }
        return res;
    }
}