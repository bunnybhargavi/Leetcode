class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n;i++){
            String t = tokens[i];
            if(t.equals("+") || t.equals("-")|| t.equals("*")|| t.equals("/")){
                int a = st.pop();
                int b = st.pop();
                int res =0;
                if(t.equals("+")) res = b+a;
                else if(t.equals("-")) res = b-a;
                else if(t.equals("*")) res = b*a;
                else res = b/a;
                st.push(res);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}