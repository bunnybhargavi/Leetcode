class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder left = new StringBuilder();
        char mid = 0;
        for(int i=0; i<26; i++){
            while(freq[i] >= 2){
                left.append((char)(i+'a'));
                freq[i] -=2;
            }
            if(freq[i] == 1){
                mid = (char)(i+'a');
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if(mid != 0) ans.append(mid);
        ans.append(new StringBuilder(left) . reverse());
        return ans.toString();
    }
}