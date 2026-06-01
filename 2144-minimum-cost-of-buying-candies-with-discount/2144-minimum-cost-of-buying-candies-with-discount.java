class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int ans =0;
        for(int i= n-1; i>=0; i-=3){
            ans += cost[i];
            if(i-1 >= 0){
                ans += cost[i-1];
            }
        }
        return ans;
    }
}