class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int res = 0;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            long pow = (long) m * m;
            if (pow > x) {
                r = m - 1;
            }
            else if (pow < x) {
                l = m + 1;
                res = m;
            }
            else {
                return m;
            }
        }
        return res;
    }
}