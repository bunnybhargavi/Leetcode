class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        int[] c = new int[26];
        for(int i=0; i<26; i++){
            c[i] = (char)(i+'a');
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;i++){
            int val =0;
            for(int j =0; j<words[i].length();j++){
                int idx = words[i].charAt(j) - 'a';
                val += weights[idx];
            }
            int fid = val%26;
            int id = 26-fid-1;
            char s = (char)c[id];
            sb.append(s);
        }
        return sb.toString();
    }
}