class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        k = k%(n*m);
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int idx = (i*m)+j;
                int nidx = (idx+k)%(n*m);
                int row = nidx/m;
                int col = nidx%m;
                arr[row][col] = grid[i][j];
            }
        }
        grid = arr;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<m; j++){
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}