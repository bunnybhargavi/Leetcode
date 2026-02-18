class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder sb = new StringBuilder();
        while(n !=0){
            sb.append(n%2);
            n = n/2;
        }
        int len = sb.length();
        for(int i=0; i<len-1;i++){
            if(sb.charAt(i) == sb.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}