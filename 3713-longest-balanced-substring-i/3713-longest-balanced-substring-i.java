class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n;i++){
            int[] c = new int[26];
            int d = 0;
            for(int j=i; j<n;j++){
                int val = s.charAt(j)-'a';
                c[val]++;
                if(c[val] == 1) d++;
                int max = 0;
                for(int k =0; k<26; k++){
                    max = Math.max(max,c[k]);
                }
                if(d*max == j-i+1){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}