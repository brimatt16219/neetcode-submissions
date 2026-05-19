class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while (l < r) {
            int min = Math.min(heights[r], heights[l]);
            int area = min * (r - l);
            max = Math.max(area, max);
            if (heights[r] > heights[l]) {
                l++;
            }
            else {
                r--;
            }
        }
        return max;
    }
}
