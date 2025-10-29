class Solution {
    public int minOperations(int n) {
        int l =0; 
        int r = n-1;
        int count =0;
        while(l < r){
            count += ((2*r+1) - (2*l +1))/2;
            l++;
            r--;
        }
        return count;
    }
}
