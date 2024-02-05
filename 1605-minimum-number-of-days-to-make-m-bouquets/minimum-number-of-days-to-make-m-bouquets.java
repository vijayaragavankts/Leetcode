class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * (long)k > n){
            return -1;
        }
        int left = 0;
        int right = 0;
        
        for(int i=0;i<n;i++){
            left = Math.min(left,bloomDay[i]);
            right = Math.max(right,bloomDay[i]);
        }

        int ans = 0;
        while(left < right){
            int mid = left + (right-left)/2;
            if(noOfBouquetsCanForm(bloomDay,mid,k) >= m){
                ans = right;
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return right;
    }

    public int noOfBouquetsCanForm(int[] nums, int val, int k){
        int count = 0;
        int noOfBouque = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= val){
                count++;
            }
            else{
                noOfBouque += count / k;
                count = 0;
            }
        }
        noOfBouque += count / k;
        return noOfBouque;
    }
}