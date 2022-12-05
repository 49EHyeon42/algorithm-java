import java.util.Stack;

class Solution {

    // Time complexity = O(N), Space complexity = O(N)
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

    // Time complexity = O(N), Space complexity = O(1)
    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int count1 = 0, count2 = 0; // number of '#';

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s.charAt(i) == '#' || count1 > 0)) {
                if (s.charAt(i) == '#') {
                    count1++;
                } else {
                    count1--;
                }
                i--;
            }

            while (j >= 0 && (t.charAt(j) == '#' || count2 > 0)) {
                if (t.charAt(j) == '#') {
                    count2++;
                } else {
                    count2--;
                }
                j--;
            }

            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }

        return true;
    }
}
