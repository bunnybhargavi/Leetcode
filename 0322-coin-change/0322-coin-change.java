class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp , amount+1);
        dp[0] =0;
        for(int coin : coins){
            for(int t = coin ; t<= amount; t++){
                dp[t] = Math.min(dp[t], 1+dp[t-coin]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}