class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\s+");
        int n = str.length;
        StringBuilder sb = new StringBuilder();
        for(int i =n-1; i>= 0;i--){
            if(str[i] != " "){
                str[i] = str[i].trim();
                sb.append(str[i]+" ");
            }
        }
        return sb.toString().trim();
    }
}