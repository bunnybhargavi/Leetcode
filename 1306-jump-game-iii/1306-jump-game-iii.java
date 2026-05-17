class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int idx = q.poll();
            if(arr[idx] == 0) return true;
            int f = idx + arr[idx];
            int b = idx - arr[idx];
            if(f < n && !vis[f]){
                q.add(f);
                vis[f] = true;
            }
            if(b >= 0 && !vis[b]){
                q.add(b);
                vis[b] = true;
            }
        }
        return false;
    }
}