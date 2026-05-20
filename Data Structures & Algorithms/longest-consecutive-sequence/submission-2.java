class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int longest = 1;
                while (set.contains(num + longest)) {
                    longest++;
                }
                res = Math.max(longest, res);
            }
        }
        return res;
    }
}
