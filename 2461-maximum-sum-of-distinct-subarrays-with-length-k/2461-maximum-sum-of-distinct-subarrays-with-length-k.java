class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum =0;
        int left =0;
        long ans = 0;
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int right =0; right <n; right++){
            sum += nums[right];
            mp.put(nums[right] , mp.getOrDefault(nums[right] , 0)+1);
            if(right - left+1 > k){
                sum -= nums[left];
                mp.put(nums[left] , mp.get(nums[left]) -1);
                if(mp.get(nums[left]) == 0) mp.remove(nums[left]);
                left++;
            }
            if(right - left +1 == k && mp.size() == k){
                ans = Math.max(ans , sum);
            }
        }
        return ans;
    }
}