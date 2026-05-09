class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int layer = Math.min(n,m)/2;
        for(int i=0; i<layer; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int top = i;
            int left = i;
            int right = m-i-1;
            int bottom = n-i-1;
            for(int j = left ;j <= right; j++){
                arr.add(grid[top][j]);
            }
            for(int j=top+1 ; j<=bottom ; j++){
                arr.add(grid[j][right]);
            }
            for(int j =right-1; j>=left; j--){
                arr.add(grid[bottom][j]);
            }for(int j=bottom -1; j > top ; j--){
                arr.add(grid[j][left]);
            }
            int size = arr.size();
            int rot = k%size;
            ArrayList<Integer> rotated = new ArrayList<>();
            for(int j=0; j<size; j++){
                rotated.add(arr.get((j+rot)%size));
            }
            int idx =0;
            for (int j = left; j <= right; j++)
                grid[top][j] = rotated.get(idx++);
            for (int j = top + 1; j <= bottom; j++)
                grid[j][right] = rotated.get(idx++);
            for (int j = right - 1; j >= left; j--)
                grid[bottom][j] = rotated.get(idx++);
            for (int j = bottom - 1; j > top; j--)
                grid[j][left] = rotated.get(idx++);
        }
        return grid;
    }
}