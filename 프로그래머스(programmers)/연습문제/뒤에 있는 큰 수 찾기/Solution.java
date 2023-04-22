public class Solution {

    public int[] solution(int[] numbers) {
        Stack stack = new Stack(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        return numbers;
    }

    private static class Stack {

        private final int[] array;
        private int top;

        public Stack(int size) {
            this.array = new int[size];
            this.top = -1;
        }

        public void push(int value) {
            array[++top] = value;
        }

        public int pop() {
            return array[top--];
        }

        public int peek() {
            return array[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
