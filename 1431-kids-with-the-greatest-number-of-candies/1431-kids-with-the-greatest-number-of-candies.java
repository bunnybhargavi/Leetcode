class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int n = candies.length;
        int maxele = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxele = Math.max(maxele , candies[i]);
        }
        for(int i=0; i<n; i++){
            if(candies[i] + extraCandies >= maxele){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}