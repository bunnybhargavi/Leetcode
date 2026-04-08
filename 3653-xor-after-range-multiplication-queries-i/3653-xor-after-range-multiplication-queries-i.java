class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        for(int i =0; i<m;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];
            for(int j =l ; j<= r; j+=k){
                nums[j] = (int)(((long)nums[j]*v)%1000000007);
            }
        }
        int res =0;
        for(int i=0;i<n;i++){
            res ^= nums[i];
        }
        return res;
    }
}