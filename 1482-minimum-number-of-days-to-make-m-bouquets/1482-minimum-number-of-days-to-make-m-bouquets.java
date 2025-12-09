class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            l = Math.min(bloomDay[i],l);
            r = Math.max(bloomDay[i],r);
        }
        int ans = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(isfound(bloomDay,mid,m,k)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean isfound(int[] arr, int mid, int m, int k){
        int c = 0;
        int num =0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] <= mid){
                c++;
            }else{
                num += c/k;
                c = 0; 
            }
        }
        num += c/k;
        if(num >= m) return true;
        else return false;
    }
}