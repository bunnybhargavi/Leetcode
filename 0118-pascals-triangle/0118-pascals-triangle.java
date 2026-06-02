class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1; i<=n;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
    public static List<Integer> generateRow(int num){
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add((int)ans);
        for(int i=1;i<num;i++){
            ans = ans*(num-i);
            ans = ans/i;
            res.add((int)ans);
        }
        return res;
    }
}