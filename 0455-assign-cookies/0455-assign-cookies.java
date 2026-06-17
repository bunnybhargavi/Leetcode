class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int c =0;
        int i=0;
        int j =0;
        while(i <n && j <s.length){
            if(g[i] <= s[j]){
                i++;
                c++;
                j++;
            }else j++;
        }
        return c;
    }
}