class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        powerset(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }
    public void powerset(int[] nums , int idx , List<Integer> cur , List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for(int i = idx ; i< nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            powerset(nums , i+1 , cur , ans);
            cur.remove(cur.size() - 1);
        }
    }
}