class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        ArrayList<int[]> ls = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            ls.add(new int[]{difficulty[i] , profit[i]});
        }
        Collections.sort(ls , (a, b) -> Integer.compare(a[0] , b[0]));
        int idx=0;
        int maxp =0;
        int ans =0;
        for(int work : worker){
            while(idx < ls.size() && ls.get(idx)[0] <= work){
                maxp = Math.max(maxp , ls.get(idx)[1]);
                idx++;
            }
            ans += maxp;
        }
        return ans;
    }
}