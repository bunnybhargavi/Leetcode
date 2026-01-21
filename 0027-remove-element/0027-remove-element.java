class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int c =0;
        while(i <j){
            if(nums[i] == val && nums[j] != val){
                swap(i,j,nums);
                i++;
                j--;
            }else if(nums[i] == val && nums[j] == val){
                j--;
            }else{
                i++;
            }
        }
        for(int k=0; k<n;k++){
            if(nums[k] != val) c++;
        }
        return c;
    }
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}