class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1 && intervals[0][0] != intervals[0][1]) return new int[]{-1};
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            int tar = intervals[i][1];
            int minstart = Integer.MAX_VALUE;
            int minidx = -1;
            for(int j =0;j<n;j++){
                if(intervals[j][0] >= tar && intervals[j][0] < minstart){
                    minstart = intervals[j][0];
                    minidx = j;
                }
            }
            res[i] = minidx;
        }
        return res;
    }
}