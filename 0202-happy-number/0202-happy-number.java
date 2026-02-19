class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> mp = new HashSet<>();
        while(n != 1){
            if(mp.contains(n)) return false;
            mp.add(n);
            n = getsum(n);
        }
        return true;
    }
    public int getsum(int n){
        int sum =0;
        while(n != 0){
            int rem = n%10;
            sum += rem*rem;
            n = n/10;
        }
        return sum;
    }
}