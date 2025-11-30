class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = firstEle(nums,n ,target);
        if(start == -1) return new int[]{-1,-1};
        int end = lastEle(nums,n,target);
        return new int[]{start , end};
    }
    public int firstEle(int[] nums, int n , int target){
        int l =0;
        int r = n-1;
        int s = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                s = mid;
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return s;
    }

    public int lastEle(int[] nums, int n , int target){
        int l =0;
        int r = n-1;
        int last = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                last = mid;
                l = mid+1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return last;
    }
}