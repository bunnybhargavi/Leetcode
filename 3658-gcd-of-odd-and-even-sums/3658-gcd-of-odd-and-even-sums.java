class Solution {
    public int gcdOfOddEvenSums(int n) {
        int esum = n*(n+1);
        int osum = n*n;
        return gcd(esum , osum);
    }
    public int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a%b);
    }
}