class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n+1];
        for(int i=0; i<n;i++){
            isPrime[i] = true;
        }
        for(int i=2; i*i <= n; i++){
            if(isPrime[i]){
                for(int p = i*i; p <n; p+=i){
                    isPrime[p] = false;
                }
            }
        }
        int c =0;
        for(int i =2; i<n; i++){
            if(isPrime[i]) c++;
        }
        return c;
    }
}