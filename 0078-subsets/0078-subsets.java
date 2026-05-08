class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        powerset(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }
    public void powerset(int[] nums , int idx , List<Integer> cur , List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        powerset(nums, idx+1 , cur , ans);
        cur.remove(cur.size() -1);
        powerset(nums , idx+1, cur , ans);
    }
}