import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0, currentIndex = 1; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == currentIndex) {
                currentIndex++;

                while (!stack.isEmpty() && stack.peek() == currentIndex) {
                    stack.pop();
                    currentIndex++;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() < value) {
                    break;
                }

                stack.push(value);
            }
        }

        bw.write(stack.isEmpty() ? "Nice" : "Sad");

        bw.flush();
        bw.close();
    }
}
