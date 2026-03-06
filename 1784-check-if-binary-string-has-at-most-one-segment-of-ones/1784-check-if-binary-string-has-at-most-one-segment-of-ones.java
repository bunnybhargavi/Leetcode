class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int c =0;
        for(int i=0; i<n;i++){
            if(s.charAt(i) == '1' && (i == 0 || s.charAt(i-1) == '0')){
                c++;
            }
        }
        return c <= 1;
    }
}