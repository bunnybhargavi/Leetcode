class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int left =0;
        int sum =0;
        double maxres = Integer.MIN_VALUE;
        for(int right =0; right < n; right++){
            sum += nums[right];
            if(right - left +1 == k){
                maxres = Math.max(maxres , (double)sum/k);
                sum -= nums[left];
                left++;
            }
        }
        return maxres;
    }
}