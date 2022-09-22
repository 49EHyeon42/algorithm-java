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

        char[] string = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;

        for (char c1 : string) {
            if (c1 == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c1);

                flag = true;
            } else if (c1 == '>') {
                sb.append(c1);

                flag = false;
            } else if (flag) {
                sb.append(c1);
            } else {
                if (c1 == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c1);
                } else {
                    stack.push(c1);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
