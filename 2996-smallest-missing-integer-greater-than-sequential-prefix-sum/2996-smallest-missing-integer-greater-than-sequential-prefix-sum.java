class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int c =nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1]+1 || nums[i] == nums[i-1]){
                break;
            }else{
                c+= nums[i];
            }
        }
        while(set.contains(c)){
            c++;
        }
        return c;
    }
}