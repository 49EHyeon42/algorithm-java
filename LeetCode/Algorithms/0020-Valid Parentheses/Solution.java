import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(map.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
