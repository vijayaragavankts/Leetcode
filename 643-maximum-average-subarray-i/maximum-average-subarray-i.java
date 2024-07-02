class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = k-1;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int x=i;x<=j;x++){
            sum += nums[x];
        }
        if(sum > max){
            max = sum;
        }
        System.out.println(sum);
        while(j < n-1){
            sum = sum - nums[i];
            i++;
            j++;
            sum += nums[j];
            if(sum > max){
                max = sum;
            }
            System.out.println(sum);
        }
        
        return (double) max / k;
    }
}