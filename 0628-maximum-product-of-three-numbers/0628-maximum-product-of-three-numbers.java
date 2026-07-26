class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        res = nums[n-1]*nums[n-2]*nums[n-3];
        res = Math.max(res , nums[0] * nums[1] * nums[n-1]);
        return res;
    }
}