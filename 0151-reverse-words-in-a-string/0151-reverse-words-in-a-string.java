class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0;i--){
            sb.append(arr[i]+" ");
        }
        return sb.toString().trim();
    }
}