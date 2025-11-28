class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet();
        int f = -1;
        int s = -1;
        for(int i=0; i<n;i++){
            if(set.contains(nums[i])){
                f = nums[i];
            }
            set.add(nums[i]);
        }
        for(int i=1; i<=n ;i++){
            if(!set.contains(i)){
                s = i;
                break;
            }
        }
        return new int[]{f,s};
    }
}