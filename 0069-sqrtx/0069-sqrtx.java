class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int l =0;
        int r = x/2;
        int ans = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            long res = (long)mid*mid;
            if(res <= x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}