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

        Stack<Character> stack = new Stack<>();

        String string = br.readLine();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == '*' || ch == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == '+' || ch == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write((sb.toString()));

        bw.flush();
        bw.close();
    }
}
