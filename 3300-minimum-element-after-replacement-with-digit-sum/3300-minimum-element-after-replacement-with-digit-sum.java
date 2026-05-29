class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int sum = digitSum(nums[i]);
            ans = Math.min(ans , sum);
        }
        return ans;
    }
    public int digitSum(int n){
        int sum =0;
        while(n != 0){
            int rem = n%10;
            sum += rem;
            n = n/10;
        }
        return sum;
    }
}