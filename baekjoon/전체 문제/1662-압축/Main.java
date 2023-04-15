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

        // MAX_SIZE = 50
        Stack stack = new Stack(50);

        int length = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') { // 괄호가 나오기전 한자리 정수가 필수 -> 예외 처리 X
                stack.push(--length, chars[i - 1] - '0');
                length = 0;
            } else if (chars[i] == ')') {
                int[] ints = stack.pop();
                length = ints[0] + ints[1] * length;
            } else {
                length++;
            }
        }

        bw.write(Integer.toString(length));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Stack {

        private final int[][] array;
        private int top;

        public Stack(int size) {
            this.array = new int[size][2];
            this.top = -1;
        }

        public void push(int a, int b) {
            if (top == array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            array[++top][0] = a;
            array[top][1] = b;
        }

        public int[] pop() {
            if (isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return array[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
