class Solution {
    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 == 1) return false;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        int target = Arrays.stream(nums).sum() / 2;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return false;
    }
}
