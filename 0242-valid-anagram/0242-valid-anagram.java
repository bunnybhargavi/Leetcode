class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        int n = s.length();
        int m = t.length();
        for(int i=0; i<n;i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0; i<m;i++){
            a[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26;i++){
            if(a[i] != 0) return false;
        }
        return true;
    }
}