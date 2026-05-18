class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        HashMap<Integer , List<Integer>> mp = new HashMap<>();
        for(int i=0; i<n;i++){
            mp.putIfAbsent(arr[i] , new ArrayList<>());
            mp.get(arr[i]).add(i);
        }
        int start =0;
        int c =0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0; j<size; j++){
                int idx = q.poll();
                if(idx == n-1) return c;
                if(idx-1 >= 0 && !vis[idx-1]){
                    vis[idx-1] = true;
                    q.add(idx-1);
                }
                if(idx+1 < n && !vis[idx+1]){
                    vis[idx+1] = true;
                    q.add(idx+1);
                }
                if(mp.containsKey(arr[idx])){
                    for(int next : mp.get(arr[idx])){
                        if(!vis[next]){
                            vis[next] = true;
                            q.add(next);
                        }
                    }
                    mp.remove(arr[idx]);
                }
            }
            c++;
        }
        return -1;
    }
}