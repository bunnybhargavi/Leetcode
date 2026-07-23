class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return subarray(nums, k) - subarray(nums, k-1);
    }
    public int subarray(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int left =0;
        int c =0;
        for(int right =0; right <n; right++){
            mp.put(nums[right] , mp.getOrDefault(nums[right] , 0)+1);
            while(mp.size() > k){
                mp.put(nums[left] , mp.get(nums[left]) -1);
                if(mp.get(nums[left]) == 0) mp.remove(nums[left]);
                left++;
            }
            c += right-left+1;
        }
        return c;
    }
}