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
        StringBuilder sb = new StringBuilder();

        Stack stack = new Stack(25);

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #").append(i).append(": ");

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Stack {

        private final String[] array;
        private int top;

        public Stack(int size) {
            this.array = new String[size];
            this.top = -1;
        }

        public void push(String value) {
            if (top == array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            array[++top] = value;
        }

        public String pop() {
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
