class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int nodel = arr[0];
        int del = 0;
        for(int i=1; i<n;i++){
            del = Math.max(nodel,del+arr[i]);
            nodel = Math.max(arr[i],nodel+arr[i]);
            res = Math.max(res,Math.max(nodel,del));
        }
        return res;
    }
}