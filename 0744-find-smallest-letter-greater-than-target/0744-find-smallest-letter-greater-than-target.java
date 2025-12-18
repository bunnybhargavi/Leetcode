class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l =0;
        int r = n-1;
        char ans = letters[l];
        while(l <= r){
            int mid = l+(r-l)/2;
            if(letters[mid] > target){
                ans = letters[mid];
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}