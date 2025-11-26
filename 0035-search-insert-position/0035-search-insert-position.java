class Solution {
    public int searchInsert(int[] nums, int target) {
        int n =nums.length;
        int l =0;
        int r = n-1;
        int ans = n;
        while(l <= r){
            int mid = l+(r-l);
            if(nums[mid] >= target){
                r = mid-1;
                ans = mid;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}