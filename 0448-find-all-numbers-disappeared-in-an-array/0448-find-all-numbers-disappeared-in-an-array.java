class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n;i++){
            set.add(nums[i]);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=1; i<=n;i++){
            if(!set.contains(i)){
                ls.add(i);
            }
        }
        return ls;
    }
}