class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<Integer> perm, int[] nums, boolean[] used) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;
                backtrack(perm, nums, used);
                used[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
