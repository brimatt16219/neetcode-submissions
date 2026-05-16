class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-z0-9]","");
        return isLowerPalindrome(lower);
    }

    boolean isLowerPalindrome(String s) {
        int right = s.length() - 1;
        for (int left = 0; left < s.length() / 2; left++) {
            if (s.charAt(left) != s.charAt(right)) return false;
            right --;
        }
        return true;
    }
}