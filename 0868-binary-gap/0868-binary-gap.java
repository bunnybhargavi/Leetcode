class Solution {
    public int binaryGap(int n) {
        String bit = Integer.toBinaryString(n);
        int res =0;
        int prev = -1;
        for(int i=0; i<bit.length();i++){
            if(bit.charAt(i) == '1'){
                if(prev != -1){
                    res = Math.max(res , i-prev);
                }
                prev = i;
            }
        }
        return res;
    }
}