class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max =0;
        for(int x : nums) max = Math.max(max , x);
        int[] arr = new int[max+1];
        Arrays.fill(arr , 0);
        for(int i=0; i<n; i++){
            arr[nums[i]] += nums[i];
        }
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0] , arr[1]);
        for(int i=2; i<=max; i++){
            int ta = arr[i]+prev2;
            int nt = prev1;
            int cur = Math.max(ta , nt);
            prev2 = prev1;
            prev1= cur;
        }
        return prev1;
    }
}