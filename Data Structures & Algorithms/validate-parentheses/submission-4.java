class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openToClose = new HashMap<>();

        openToClose.put(')', '(');
        openToClose.put(']', '[');
        openToClose.put('}', '{');
        
        for (char c : s.toCharArray()) {
            if (openToClose.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == openToClose.get(c)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
