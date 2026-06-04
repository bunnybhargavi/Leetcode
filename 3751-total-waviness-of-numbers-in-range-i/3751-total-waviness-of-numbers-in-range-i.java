class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans =0;
        for(int i = num1; i<= num2; i++){
            ans += tcount(i);
        }
        return ans;
    }
    public int tcount(int num1){
        ArrayList<Integer> a1 = new ArrayList<>();
        while(num1 != 0){
            int rem = num1%10;
            a1.add(rem);
            num1 = num1/10;
        }
        if(a1.size() < 3) return 0;
        int res =0;
        for(int i=1; i<a1.size()-1; i++){
            if(a1.get(i-1) < a1.get(i) && a1.get(i) > a1.get(i+1)) res++;
            if(a1.get(i-1) > a1.get(i) && a1.get(i) < a1.get(i+1)) res++;
        }
        return res;
    }
}