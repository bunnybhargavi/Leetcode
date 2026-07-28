class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int h = n/2;
        char[] arr = s.substring(0 , h).toCharArray();
        Arrays.sort(arr);
        String fh = new String(arr); 
        String str = fh+((n%2 == 1) ? s.charAt(h) : "") + (new StringBuilder(new String(fh)).reverse());
        return str;
    }
}