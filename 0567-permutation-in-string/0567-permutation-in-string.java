class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        int left =0;
        for(int i=0; i<k; i++){
            char ch = s1.charAt(i);
            f1[ch - 'a']++;
        }
        for(int right =0; right<s2.length(); right++){
            char ch = s2.charAt(right);
            f2[ch-'a']++;
            if(right - left+1 > k){
                f2[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1 == k){
                if(Arrays.equals(f1 , f2)) return true;
            }
        }
        return false;
    }
}