class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j = n-1;
        int area = 0;
        while(i < n && j >= 0){
            int h = Math.min(height[i] , height[j]);
            int w = j-i;
            area = Math.max(area , h*w);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return area;
    }
}