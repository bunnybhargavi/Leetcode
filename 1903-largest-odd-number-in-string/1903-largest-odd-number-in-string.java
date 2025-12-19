class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int idx = -1;
        for(int i =n-1;i>=0;i--){
            int d = num.charAt(i)-'0';
            if(d%2 != 0){
                idx = i;
                break;
            }
        }
        if(idx == -1) return "";
        int i=0;
        while(i <= idx && num.charAt(i) == '0') i++;
        return num.substring(i,idx+1);
    }
}