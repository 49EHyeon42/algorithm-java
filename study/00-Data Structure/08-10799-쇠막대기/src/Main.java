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
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            } else {
                stack.pop();
                answer = (string.charAt(i - 1) == '(') ? answer + stack.size() : answer + 1;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
