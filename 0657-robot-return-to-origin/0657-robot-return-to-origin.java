class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0;
        int d = 0;
        int l =0;
        int r = 0;
        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U') u++;
            else if(c == 'D') d++;
            else if(c == 'L') l++;
            else if(c == 'R') r++;
        }
        if(u == d && l == r) return true;
        return false;
    }
}