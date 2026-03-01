class Solution {
    public int minPartitions(String n) {
        int ans =0;
        for(int i=0; i<n.length(); i++){
            char ch = n.charAt(i);
            ans = Math.max(ans , ch-'0');
        }
        return ans;
    }
}