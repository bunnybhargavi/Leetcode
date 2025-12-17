class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int c =0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(c > 0) sb.append(ch);
                c++;
            }else if(ch == ')'){
                c--;
                if(c > 0) sb.append(ch);
            }
        }
        return sb.toString();
    }
}