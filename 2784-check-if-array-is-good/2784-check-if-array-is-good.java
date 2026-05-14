class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(max , nums[i]);
        }
        if(n != (max+1)) return false;
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int i=0; i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 1; i < max; i++){
            if(mp.getOrDefault(i, 0) != 1){
                return false;
            }
        }
        return mp.getOrDefault(max, 0) == 2;
    }
}