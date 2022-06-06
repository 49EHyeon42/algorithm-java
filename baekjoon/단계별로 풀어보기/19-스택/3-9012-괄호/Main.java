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

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] string = br.readLine().toCharArray();

            Stack<String> stack = new Stack<>();

            boolean flag = true;
            for (char c : string) {
                if (c == '(') {
                    stack.push("(");
                } else {
                    if (stack.size() != 0) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            sb.append((stack.size() == 0 && flag) ? "YES" : "NO").append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
