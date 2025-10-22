class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        double kel = celsius + 273.15;
        double far = celsius * 1.80 + 32.00;
        res[0] = kel;
        res[1] = far;
        return res;
    }
}