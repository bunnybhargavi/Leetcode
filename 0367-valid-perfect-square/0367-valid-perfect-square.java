class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int l = 0;
        int r = num/2;
        while(l <= r){
            int mid = l+(r-l)/2;
            long res = (long)mid*mid;
            if(res == num){
                return true;
            }else if(res < num){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}