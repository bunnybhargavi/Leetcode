class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<n;i++){
            int num = nums[i];
            String s = String.valueOf(num);
            for(int j=0; j<s.length(); j++){
                ls.add(s.charAt(j) - '0');
            }
        }
        int n2 = ls.size();
        int[] ans = new int[n2];
        for(int i=0; i<n2; i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}