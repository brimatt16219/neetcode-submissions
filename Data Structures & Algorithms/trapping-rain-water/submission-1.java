class Solution {
    public int trap(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int res = 0;
        while (l < r) {
            int min = Math.min(maxL, maxR);
            if (maxL < maxR) {
                l++;
                res += Math.max(0, min - height[l]);
                maxL = Math.max(height[l], maxL);
            }
            else {
                r--;
                res += Math.max(0, min - height[r]);
                maxR = Math.max(height[r], maxR);
            }
        }
        return res;
    }
}
