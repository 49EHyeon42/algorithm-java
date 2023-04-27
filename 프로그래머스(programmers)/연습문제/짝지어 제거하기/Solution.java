public class Solution {

    public int solution(String string) {
        char[] chars = string.toCharArray();

        Stack stack = new Stack(chars.length);

        for (char c : chars) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }

            stack.pop();
        }

        return (stack.isEmpty()) ? 1 : 0;
    }

    private static class Stack {

        private char[] array;
        private int top;

        public Stack(int maxSize) {
            this.array = new char[maxSize];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(char c) {
            array[++top] = c;
        }

        public char pop() {
            return array[top--];
        }

        public char peek() {
            return array[top];
        }
    }
}
