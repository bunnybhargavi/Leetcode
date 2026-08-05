class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<m; i++){
            mp.put(arr2[i] , 0);
        }
        ArrayList<Integer> rem = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(arr1[i])){
                mp.put(arr1[i] , mp.get(arr1[i])+1);
            }else{
                rem.add(arr1[i]);
            }
        }
        Collections.sort(rem);
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr2) {
            for (int i = 0; i < mp.get(num); i++) {
                res.add(num);
            }
        }
        res.addAll(rem);
        int[] ans = new int[n];
        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}