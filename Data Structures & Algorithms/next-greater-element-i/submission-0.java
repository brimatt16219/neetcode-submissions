class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                continue;
            }
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    int index = map.get(nums2[i]);
                    res[index] = nums2[j];
                    break;
                } 
            }
        }
        return res;
    }
}