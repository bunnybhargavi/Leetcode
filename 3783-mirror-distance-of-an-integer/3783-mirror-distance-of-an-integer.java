class Solution {
    public int mirrorDistance(int n) {
        int val = reverse(n);
        return Math.abs(n- val);
    }
    public int reverse(int n){
        int rev =0;
        while(n != 0){
            int rem = n%10;
            rev = rev*10+rem;
            n = n/10;
        }
        return rev;
    }
}