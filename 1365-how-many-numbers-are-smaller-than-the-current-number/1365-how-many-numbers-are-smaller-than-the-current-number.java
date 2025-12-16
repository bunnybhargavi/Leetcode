class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // int n = nums.length;
        // int[] res = new int[n];
        // for(int i=0; i<n;i++){
        //     int c =0;
        //     for(int j = 0; j<n;j++){
        //         if(nums[j] < nums[i]){
        //             c++;
        //         }
        //     }
        //     res[i] = c;
        // }
        // return res;

        int n = nums.length;
        int[] c = new int[101];
        for(int i=0; i<n;i++){
            c[nums[i]]++;
        }
        for(int i=1; i<= 100;i++){
            c[i] += c[i-1];
        }
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            if(nums[i] == 0){
                res[i] =0;
            }else{
                res[i] = c[nums[i] - 1];
            }
        }
        return res;

    }
}