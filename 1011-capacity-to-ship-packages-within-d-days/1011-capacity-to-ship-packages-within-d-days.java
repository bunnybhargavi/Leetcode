class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int ans = 0;
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while(l <= r){
            int mid = l+(r-l)/2;
            if(possible(weights , days , mid)){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }
    public boolean possible(int[] weights , int days, int mid){
        int day =1;
        int cur =0;
        for(int val : weights){
            if(cur + val <= mid) cur += val;
            else{
                day++;
                cur = val;
            }
        }
        return day <= days;
    }
}