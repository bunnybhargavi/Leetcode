class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ans =Integer.MAX_VALUE;;
        s = s+s;
        int flip0 = 0;
        int flip1 = 0;
        for(int i=0; i<2*n;i++){
            char exp1 = (i%2 == 0) ? '0' : '1';
            char exp2 = (i%2 == 0) ? '1' : '0';
            if(s.charAt(i) != exp1) flip0++;
            if(s.charAt(i) != exp2) flip1++;
            if(i >= n){
                char left = s.charAt(i-n);
                int expl0 = ((i-n)%2 == 0) ? '0' :'1';
                int expl1 = ((i-n)% 2 == 0)? '1' : '0';
                if(left != expl0) flip0--;
                if(left != expl1) flip1--;
            }
            if(i >= n-1){
                ans = Math.min(ans , Math.min(flip0 , flip1));
            }
        }
        return ans;
    }
}