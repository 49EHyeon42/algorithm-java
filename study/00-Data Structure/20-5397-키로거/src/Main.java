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
        StringBuilder answerSb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String string = br.readLine();

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for (int j = 0; j < string.length(); j++) {
                char ch = string.charAt(j);

                if (ch == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else if (ch == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (ch == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else {
                    leftStack.push(ch);
                }
            }

            while (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!leftStack.isEmpty()) {
                sb.append(leftStack.pop());
            }
            answerSb.append(sb.reverse()).append('\n');
        }

        bw.write(answerSb.toString().trim());

        bw.flush();
        bw.close();
    }
}
