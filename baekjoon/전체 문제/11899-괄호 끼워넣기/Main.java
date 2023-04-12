import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();

        int size = chars.length;

        Stack stack = new Stack(size);

        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        bw.write(Integer.toString(stack.getSize() + 1));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Stack {

        private final char[] array;
        private int top;

        public Stack(int size) {
            this.array = new char[size];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int getSize() {
            return top;
        }

        public void push(char value) {
            if (top == array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            array[++top] = value;
        }

        public char pop() {
            if (top == -1) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return array[top--];
        }

        public char peek() {
            if (top == -1) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return array[top];
        }
    }
}
