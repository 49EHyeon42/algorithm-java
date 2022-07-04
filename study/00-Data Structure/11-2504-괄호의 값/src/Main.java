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

        Stack<Character> stack = new Stack<>();

        String string = br.readLine();

        int answer = 0;
        int temp = 1;
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = true;
                    break;
                } else if (string.charAt(i - 1) == '(') {
                    answer += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = true;
                    break;
                } else if (string.charAt(i - 1) == '[') {
                    answer += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (flag || !stack.isEmpty()) {
            answer = 0;
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
