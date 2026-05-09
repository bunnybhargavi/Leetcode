class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates , target , new ArrayList<>() , 0 , ans);
        return ans;
    }
    public void backtrack(int[] nums , int tar  , List<Integer> cur ,int idx , List<List<Integer>> ans){
        if(tar == 0){
            ans.add(new ArrayList<>(cur));
            return ;
        }
        if(tar < 0 || idx == nums.length) {
            return;
        }
        cur.add(nums[idx]);
        backtrack(nums , tar -nums[idx] , cur , idx, ans);
        cur.remove(cur.size()-1);
        backtrack(nums , tar , cur , idx+1, ans);
    }
}