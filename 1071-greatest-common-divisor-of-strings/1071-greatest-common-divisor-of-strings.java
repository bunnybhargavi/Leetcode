class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int len = gcd(n , m);
        return str1.substring(0 , len);
    }
    public int gcd(int a , int b){
        while(b != 0){
            int temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }
}