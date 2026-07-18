class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int s = nums[0];
        int l = nums[0];
        for(int i= 1; i<n; i++){
            s = Math.min(s , nums[i]);
            l = Math.max(l , nums[i]);
        }
        while(s != 0){
            int temp = s;
            s = l%s;
            l = temp;
        }
        return l;
    }
}