class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[0];
        int cur = cost[1];
        for(int i=2; i<n; i++){
            int temp = cost[i]+Math.min(prev , cur);
            prev = cur;
            cur = temp;
        }
        return Math.min(prev ,cur);
    }
}