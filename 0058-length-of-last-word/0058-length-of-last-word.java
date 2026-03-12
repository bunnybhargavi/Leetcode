class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int len =0;
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == ' ') break;
            len++;
        }
        return len;
    }
}