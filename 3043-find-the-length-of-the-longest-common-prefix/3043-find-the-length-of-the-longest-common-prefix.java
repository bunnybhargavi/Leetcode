class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        HashSet<String> st = new HashSet<>();
        for(int num : arr1){
            String s = String.valueOf(num);
            for(int i=1; i<=s.length(); i++){
                st.add(s.substring(0, i));
            }
        }
        int ans =0;
        for(int num : arr2){
            String s1 = String.valueOf(num);
            for(int i=1; i<=s1.length(); i++){
                if(st.contains(s1.substring(0, i))){
                    ans = Math.max(ans , i);
                }
            }
        }
        return ans;
    }
}