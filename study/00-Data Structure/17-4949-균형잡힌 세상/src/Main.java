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

        while (true) {
            char[] string = br.readLine().toCharArray();
            if (string[0] == '.') {
                break;
            }

            Stack<Character> stack = new Stack<>();

            boolean flag = true;
            for (char c : string) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.size() != 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.size() != 0 && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            sb.append((stack.size() == 0 && flag) ? "yes" : "no").append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
