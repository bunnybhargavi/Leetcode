class Solution {
    public int sumOfPrimesInRange(int n) {
        int l = n;
        int r =0;
        while(n != 0){
            int rem = n%10;
            r = r*10+rem;
            n = n/10;
        }
        int s = Math.min(r , l);
        int e = Math.max(r , l);
        int sum =0;
        for(int i = s; i<=e; i++){
            if(isPrime(i)) sum+=i;
        }return sum;
    }
    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}