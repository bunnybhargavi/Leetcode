class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String s = strs[0];
        String l = strs[n-1];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Math.min(s.length(),l.length());i++){
            if(s.charAt(i) != l.charAt(i)){
                break;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}