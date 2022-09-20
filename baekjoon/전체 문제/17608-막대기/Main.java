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

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            stack.push(Integer.parseInt(br.readLine()));

        }

        int count = 1;
        int currentStick = stack.pop();

        while (!stack.isEmpty()) {
            if (currentStick < stack.peek()) {
                currentStick = stack.peek();
                count++;
            }

            stack.pop();
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
