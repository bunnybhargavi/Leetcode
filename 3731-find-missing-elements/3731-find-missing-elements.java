class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int minele = Integer.MAX_VALUE;
        int maxele = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            minele = Math.min(minele , nums[i]);
            maxele = Math.max(maxele , nums[i]);
            set.add(nums[i]);
        }
        for(int i=minele; i<=maxele; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}