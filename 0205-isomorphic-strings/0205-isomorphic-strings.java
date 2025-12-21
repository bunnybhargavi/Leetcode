class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;
        int[] s1 = new int[256];
        int[] t1 = new int[256];
        for(int i=0; i<n1;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(s1[c1] != t1[c2]) return false;
            s1[c1] = i+1;
            t1[c2] = i+1;
        }
        return true;
    }
}