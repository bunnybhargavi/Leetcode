class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;
        Map<Character,Character> mp1 = new HashMap<>();
        Map<Character,Character> mp2 = new HashMap<>();
        for(int i=0; i<n1;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(mp1.containsKey(c1)){
                if(mp1.get(c1) != c2) return false;
            }
            mp1.put(c1,c2);
            if(mp2.containsKey(c2)){
                if(mp2.get(c2) != c1) return false;
            }
            mp2.put(c2,c1);
        }
        return true;
    }
}