class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l = 1;
        int r = -1;
        for(int i=0; i<n;i++){
            r = Math.max(nums[i],r);
        }
        int ans = r;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(isdivide(nums,mid,threshold)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean isdivide(int[] arr, int mid, int t){
        int sum = 0;
        for(int i=0; i<arr.length;i++){
            sum += Math.ceil((double)arr[i]/mid);
        }
        if(sum <= t) return true;
        else return false;
    }
}