class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long evenpart = Power(5,even);
        long oddpart = Power(4,odd);
        return (int)((evenpart*oddpart)%mod);
    }
    public long Power(long num, long exp){
        long res =1;
        while(exp > 0){
            if((exp&1)== 1){
                res = (num*res)%mod;
            }
            num = (num*num)%mod;
            exp >>= 1;
        }
        return res;
    }
}