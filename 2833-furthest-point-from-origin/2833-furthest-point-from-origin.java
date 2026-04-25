class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int l =0;
        int r =0;
        int u =0;
        for(int i=0; i<n;i++){
            char ch = moves.charAt(i);
            if(ch == 'L') l++;
            else if(ch == 'R') r++;
            else if(ch == '_') u++;
        }
        return Math.abs(l-r)+u;
    }
}