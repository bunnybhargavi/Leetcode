class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count0 = 0;
        int count1 =0;
        int ans =0;
        for(int i=0;i <n;i++){
            if(i%2 == 0){
                if(s.charAt(i) != '0') count0++;
                if(s.charAt(i) != '1') count1++;
            }else{
                if(s.charAt(i) != '1') count0++;
                if(s.charAt(i) != '0') count1++;
            }
        }
        ans = Math.min(count0, count1);
        return ans;
    }
}