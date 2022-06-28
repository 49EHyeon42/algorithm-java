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

        int n = Integer.parseInt(br.readLine());

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        int value = 1;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            while (value <= input) {
                stack.push(value);
                sb.append("+\n");
                value++;
            }

            if (stack.peek() == input) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = false;
                break;
            }
        }

        String answer;
        if (flag) {
            answer = sb.toString().trim();
        } else {
            answer = "NO";
        }

        bw.write(answer);

        bw.flush();
        bw.close();
    }
}
