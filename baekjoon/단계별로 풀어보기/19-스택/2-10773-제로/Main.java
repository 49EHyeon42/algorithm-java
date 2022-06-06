import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        bw.write(Integer.toString(stack.stream().mapToInt(i -> i).sum()));

        bw.flush();
        bw.close();
    }
}
