class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums , 0, n-1);
        return nums;
    }
    public void mergeSort(int[] arr , int l , int r){
        if(l >= r) return;
        int mid = l+(r-l)/2;
        mergeSort(arr , l , mid);
        mergeSort(arr , mid+1 , r);
        merge(arr , l , mid, r);
    }
    public void merge(int[] arr , int l , int mid , int r){
        int i =l;
        int j =mid+1;
        int k =0;
        int[] temp = new int[arr.length];
        while(i <= mid && j <= r){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= r){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(int a=l; a<=r;a++){
            arr[a] = temp[a-l];
        }
    }
}