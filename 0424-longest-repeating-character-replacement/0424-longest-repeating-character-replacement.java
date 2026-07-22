class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> mp = new HashMap<>();
        int n = s.length();
        int maxfreq = 0;
        int left =0;
        int ans =0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            mp.put(ch , mp.getOrDefault(ch , 0)+1);
            maxfreq = Math.max(maxfreq , mp.get(ch));
            while((i-left+1) - maxfreq > k){
                char lch = s.charAt(left);
                mp.put(lch , mp.get(lch) -1);
                if(mp.get(lch) == 0) mp.remove(lch);
                left++;
            }
            ans = Math.max(ans , i-left+1);
        }
        return ans;
    }
}