class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans =0;
        for(int i = n-1; i>= 0; i--){
            if(colors[i] != colors[0]){
                ans = i;
                break;
            }
        }
        for(int j =0; j<n;j++){
            if(colors[j] != colors[n-1]){
                ans = Math.max(ans , n-1-j);
                break;
            }
        }
        return ans;
    }
}