class Solution {
    public char findKthBit(int n, int k) {
        String s = buildString(n);
        return s.charAt(k - 1);
    }

    public String buildString(int n) {
        if (n == 1) return "0";

        String prev = buildString(n - 1);
        String inverted = invert(prev);
        String reversed = reverse(inverted);

        return prev + "1" + reversed;
    }

    public String reverse(String x) {
        return new StringBuilder(x).reverse().toString();
    }

    public String invert(String x) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '0')
                sb.append('1');
            else
                sb.append('0');
        }

        return sb.toString();
    }
}