class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int c =0;
        int ans =0;
        for(int i=0; i<n;i++){
            char ch = (i%2 == 0) ?'0':'1';
            if(s.charAt(i) != ch) c++;
        }
        ans = Math.min(c , n-c);
        return ans;
    }
}