class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && st.peek() > ch && k> 0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int idx =0;
        while (idx < sb.length() && sb.charAt(idx) == '0') idx++;
        if (idx == sb.length()) return "0";
        return sb.toString().substring(idx , sb.length());
    }
}