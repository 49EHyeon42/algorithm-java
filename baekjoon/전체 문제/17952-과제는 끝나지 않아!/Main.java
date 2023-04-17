import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long total = 0;

        Stack stack = new Stack(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                stack.push(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            if (!stack.isEmpty()) {
                stack.setTime();

                if (stack.peek()[1] == 0) {
                    total += stack.pop()[0];
                }
            }
        }

        bw.write(Long.toString(total));
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

        public int[] peek() {
            if (isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return array[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void setTime() {
            array[top][1]--;
        }
    }
}
