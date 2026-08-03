class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int c = 0;
        boolean[] vis = new boolean[n]; 
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i , isConnected , vis);
                c++;
            }
        }
        return c;
    }
    public void dfs(int node , int[][] isConnected , boolean[] vis){
        vis[node] = true;
        for(int j =0; j<isConnected.length; j++){
            if(isConnected[node][j] == 1 && !vis[j]){
                dfs(j , isConnected , vis);
            }
        }
    }
}