class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int x : nums){
            sum += x;
        }
        //if(sum %2 != 0) return -1;
       int lsum =0;
       for(int i=0; i<n; i++){
        int rsum = sum - lsum - nums[i];
        if(lsum == rsum) return i;
        lsum += nums[i];
       }
        return -1;
    }
}