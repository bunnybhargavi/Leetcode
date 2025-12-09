class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l = 0;
        int r = 0;
        for(int i=0; i<n;i++){
            l = Math.max(l,weights[i]);
            r += weights[i];
        }
        int ans = r;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(isship(weights, mid, days)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean isship(int[] arr, int mid, int d){
        int load = 0;
        int day =1;
        for(int i=0; i<arr.length;i++){
            if(load +arr[i] <= mid){
                load += arr[i];
            }else{
                day++;
                load = arr[i];
                if(day > d) return false;
            }
        }
        return true;
    }
}