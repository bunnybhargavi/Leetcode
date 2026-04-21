class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for(int i =1; i<n;i++){
            int val1 = s.charAt(i-1) - '0';
            int val2 = s.charAt(i) - '0';
            ans += Math.abs(val1 - val2);
        }
        return ans;
    }
}