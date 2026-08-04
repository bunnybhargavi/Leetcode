class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int len = Math.min(n , m);
        String s = "";
        for(int i=0; i<len; i++){
            s += word1.charAt(i);
            s += word2.charAt(i);
        }
        while(len < n){
            s += word1.charAt(len);
            len++;
        }
        while(len < m){
            s+= word2.charAt(len);
            len++;
        }
        return s;
    }
}