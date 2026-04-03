class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        List<Boolean> ls = new ArrayList<>();
        for(int i=0; i<n;i++){
            int tot = candies[i] + extraCandies;
            if(tot >= max) ls.add(true);
            else ls.add(false);
        }
        return ls;
    }
}