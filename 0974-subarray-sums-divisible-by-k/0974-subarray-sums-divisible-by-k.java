class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum =0;
        int count =0;
        for(int i=0; i<n;i++){
            sum += nums[i];
            int rem = ((sum%k)+k)%k;
            if(mp.containsKey(rem)){
                count += mp.get(rem);
            }
            mp.put(rem , mp.getOrDefault(rem , 0)+1);
        }
        return count;
    }
}