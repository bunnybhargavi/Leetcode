class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        mp.put(0 , -1);
        int maxlen =0;
        int sum =0;
        for(int i=0; i<n;i++){
            if(nums[i] == 0) sum += -1;
            else sum += 1;
            if(mp.containsKey(sum)){
                maxlen = Math.max(maxlen , i - mp.get(sum));
            }else{
                mp.put(sum , i);
            }
        }
        return maxlen;
    }
}