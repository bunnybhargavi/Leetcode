class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        int ans = n;
        while(num >= n ){
            if(isdivide(num , t)){
                ans = num;
                break;
            }
            num++;
        }
        return ans;
    }
    public boolean isdivide(int num , int t){
        int pro = 1;
        while(num > 0){
            int rem = num%10;
            pro *= rem;
            num = num/10;
        }
        return pro%t == 0;
    }
}