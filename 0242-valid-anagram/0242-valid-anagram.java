class Solution {
    public boolean isAnagram(String s, String t) {
        int[] c = new int[26];
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;
        for(int i=0; i<n1;i++){
            c[s.charAt(i) -'a']++;
            c[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26;i++){
            if(c[i] != 0){
                return false;
            }
        }
        return true;
    }
}