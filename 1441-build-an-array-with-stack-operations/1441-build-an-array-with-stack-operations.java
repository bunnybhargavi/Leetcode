class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> ls = new ArrayList<>();
        int idx =0;
        for(int i=1; i<=n && idx < target.length;i++){
            ls.add("Push");
            int ele = target[idx];
            if(ele == i){
                idx++;
            }else{
                ls.add("Pop");
            }
        }
        return ls;
    }
}