class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int i=0;
        int maxlen =0;
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int j=0; j<n; j++){
            mp.put(s.charAt(j) , mp.getOrDefault(s.charAt(j) , 0)+1);
            while(mp.get(s.charAt(j)) > 2){
                mp.put(s.charAt(i) , mp.get(s.charAt(i)) -1 );
                i++;
            }
            maxlen = Math.max(maxlen , j-i+1);
        }
        return maxlen;
    }
}