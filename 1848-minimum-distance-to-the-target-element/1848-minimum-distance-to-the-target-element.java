class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int idx =0;
        for(int i=0; i<n;i++){
            if(nums[i] == target){
                idx = Math.abs(i-start);
                ans = Math.min(ans , idx);
            }
        }
        return ans;
    }
}