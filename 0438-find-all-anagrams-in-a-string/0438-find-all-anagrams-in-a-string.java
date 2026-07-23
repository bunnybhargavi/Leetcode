class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        //if(m > n) return new List<>(0);
        List<Integer> ans = new ArrayList<>();
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0; i<m; i++){
            f1[p.charAt(i) - 'a']++;
        }
        int left =0;
        for(int right =0; right <n; right++){
            char ch = s.charAt(right);
            f2[ch - 'a']++;
            if(right - left +1 > m){
                f2[s.charAt(left) - 'a']--;
                left++;
            }
            if(right - left+1 == m){
                if(Arrays.equals(f1 , f2)) ans.add(left);
            }
        }
        return ans;
    }
}