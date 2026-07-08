class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int ans =0;
        ans = Math.max(ans , solve(nums , 0, n-2));
        ans = Math.max(ans , solve(nums , 1, n-1));
        return ans;
    }
    public int solve(int[] nums , int x , int y){
        if(x == y) return nums[x];
        int prev2 = nums[x];
        int prev1 = Math.max(nums[x], nums[x+1]);
        for(int i= x+2; i<=y; i++){
            int cur = Math.max(prev1 , nums[i]+prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}