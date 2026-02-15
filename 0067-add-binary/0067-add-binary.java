class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l1 = a.length();
        int l2 = b.length();
        int c =0;
        int i = l1-1;
        int j = l2-1;
        while(i >= 0 || j >= 0 || c != 0){
            int sum = c;
            if(i >= 0) sum += a.charAt(i)-'0';
            if(j >= 0) sum += b.charAt(j)-'0';
            sb.append(sum%2);
            c = sum/2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}