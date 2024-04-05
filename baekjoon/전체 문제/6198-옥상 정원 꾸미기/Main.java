import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // stack에 있는 빌딩은 내려다 보는 빌딩이다.
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }

            sum += stack.size();

            stack.push(h);
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
