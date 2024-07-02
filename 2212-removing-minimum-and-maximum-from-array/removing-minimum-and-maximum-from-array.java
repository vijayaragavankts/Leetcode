class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int val:nums){
            if(val < smallest){
                smallest = val;
            }
            if(val > largest){
                largest = val;
            }
        }
        // traverse in both front and back to find those elements
        int search_small_front = 0;
        int search_big_front = 0;
        int search_small_back = 0;
        int search_big_back = 0;
        for(int val:nums){
            search_small_front++;
            if(val == smallest){
                break;
            }
        }
        for(int val:nums){
            search_big_front++;
            if(val == largest){
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            search_small_back++;
            if(val == smallest){
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            search_big_back++;
            if(val == largest){
                break;
            }
        }
        int res = 0;
        int front = 0;
        if(search_small_front < search_big_front){
            front = search_big_front;
        }
        else{
            front = search_small_front;
        }
        int back = 0;
        if(search_small_back < search_big_back){
            back = search_big_back;
        }
        else{
            back = search_small_back;
        }
        if(search_small_back < search_small_front){
            res += search_small_back;
        }
        else{
            res += search_small_front;
        }
        if(search_big_back < search_big_front){
            res += search_big_back;
        }
        else{
            res += search_big_front;
        }
        return Math.min(res,Math.min(front,back));

    }
}