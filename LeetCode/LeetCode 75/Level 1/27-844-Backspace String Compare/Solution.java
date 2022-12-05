import java.util.Stack;

class Solution {

    public boolean backspaceCompare(String s, String t) {
        return getResult(s).equals(getResult(t));
    }

    private String getResult(String string) {
        Stack<Character> stack = new Stack<>();

        for (char character : string.toCharArray()) {
            if (character == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(character);
            }
        }

        return stack.toString();
    }
}
