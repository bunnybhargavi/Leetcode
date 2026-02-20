class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int eat = n/2;
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n;i++){
            set.add(candyType[i]);
        }
        int size = set.size();
        if(size > eat) ans = eat;
        else ans = size;
        return ans;
    }
}