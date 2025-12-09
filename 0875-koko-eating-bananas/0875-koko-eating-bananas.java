class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        int l =1; 
        int r = -1;
        for(int i =0; i<n;i++){
            max = Math.max(piles[i],max);
            r = max;
        }
        int ans = r;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(minint(piles,mid , h)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean minint(int[] piles, int mid, int h){
        int th = 0;
        for(int i=0; i<piles.length;i++){
            th += Math.ceil((double)piles[i]/mid);
        }
        if(th <= h) return true;
        else return false;
    }
}