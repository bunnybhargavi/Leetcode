class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land = cal(landStartTime, landDuration, waterStartTime, waterDuration);
        int water = cal(waterStartTime, waterDuration , landStartTime, landDuration);
        return Math.min(land , water);
    }
    public int cal(int[] s1 , int[] t1 , int[] s2 , int[] t2){
        int time = Integer.MAX_VALUE;
        for(int i=0; i<s1.length; i++){
            time = Math.min(time , s1[i]+t1[i] );
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<s2.length; i++){
            ans = Math.min(ans , Math.max(time , s2[i])+t2[i]);
        }
        return ans;
    }
}