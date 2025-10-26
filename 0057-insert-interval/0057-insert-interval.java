class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        for(int[] part : intervals){
            if(part[1] < newInterval[0]){
                res.add(part);
            }else if(part[0] > newInterval[1]){
                res.add(newInterval);
                newInterval = part;
            }else{
                newInterval[0] = Math.min(part[0],newInterval[0]);
                newInterval[1] = Math.max(part[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}