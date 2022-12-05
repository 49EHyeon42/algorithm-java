import java.util.Stack;

class Solution {

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                count = count * 10 + character - '0';
            } else if (character == '[') {
                intStack.push(count);
                strStack.push(sb);

                sb = new StringBuilder();

                // init count
                count = 0;
            } else if (character == ']') {
                StringBuilder previousSb = sb;
                sb = strStack.pop();
                sb.append(String.valueOf(previousSb).repeat(Math.max(0, intStack.pop())));
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
