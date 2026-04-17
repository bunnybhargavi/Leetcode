class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        for(int i=0; i<n;i++){
            int val = reverse(nums[i]);
            if(mp.containsKey(nums[i])){
                dist = Math.min(dist, i - mp.get(nums[i]));
            }
            mp.put(val , i);
        }
        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
    public int reverse(int num){
        int rev = 0;
        while(num != 0){
            int rem = num%10;
            rev = rev*10 +rem;
            num = num/10;
        }
        return rev;
    }
}