class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) { x = 1 / x; N = -N; }
        double res = 1.0, cur = x;
        while (N > 0) {
            if (N % 2 == 1) res *= cur;
            cur *= cur;
            N /= 2;
        }
        return res;
    }
}