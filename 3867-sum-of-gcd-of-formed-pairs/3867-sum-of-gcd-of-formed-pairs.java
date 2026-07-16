class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] gcdnum = new int[n];
        int max =nums[0];
        for(int i=0; i<n;i++){
            max = Math.max(max , nums[i]);
            gcdnum[i] = gcd(max , nums[i]);
        }
        Arrays.sort(gcdnum);
        int l =0;
        int m =n-1;
        long res =0;
        while(l <m){
            res += gcd(gcdnum[l] , gcdnum[m]);
            l++;
            m--;
        }
        return res;
    }
    public int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a%b);
    }
}