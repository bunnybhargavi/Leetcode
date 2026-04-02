class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = friends.length;
        int m = order.length;
        int[] res = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n;i++){
            set.add(friends[i]);
        }
        int j =0;
        for(int i=0; i<m;i++){
            if(set.contains(order[i])){
                res[j] = order[i];
                j++;
            }
        }
        return res;
    }
}