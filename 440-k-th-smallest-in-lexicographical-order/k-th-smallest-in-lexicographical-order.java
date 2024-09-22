class Solution {
    public int findKthNumber(int n, int k) {
        int currElement =1;
        k--;
        while(k > 0){
            long steps = countSteps(n, currElement, currElement+1);
            if(steps <= k){
                currElement++;
                k-=steps;
            } else {
                currElement *=10; 
                k--;
            }
        }
        return currElement; 
    }
    long countSteps(int n, long currElement, int next){
        long steps=0;
        while(currElement <=n){
            steps+= Math.min(n+1, next)-currElement;
            currElement *=10;
            next *=10;
        }
    return steps;
    }
}