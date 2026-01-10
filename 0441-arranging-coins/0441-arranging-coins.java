class Solution {
    public int arrangeCoins(int n) {
        int l =0;
        int r = n;
        while(l <= r){
            int mid = l+(r-l)/2;
            long step = (long) mid*(mid+1)/2;
            if(step == n){
                return mid;
            }else if(step < n){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return r;
    }
}