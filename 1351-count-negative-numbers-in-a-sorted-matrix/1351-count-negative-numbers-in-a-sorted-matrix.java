class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c =0;
        for(int i=0; i<n;i++){
            int l =0;
            int r = m-1;
            while(l <= r){
                int mid = l+(r-l)/2;
                if(grid[i][mid] < 0){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            c += m-l;
        }
        return c;
    }
}