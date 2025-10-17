class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long exp = n;
        double res =1;
        exp = Math.abs(exp);
        while(exp > 0){
            if((exp&1) == 1){
                res = res*x;
            }
            x = x*x;
            exp >>= 1;
        }
        if(n < 0){
            res = 1/res;
        }
        return res;
    }
}