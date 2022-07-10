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

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            Stack<Character> stack = new Stack<>();

            stack.add(string.charAt(0));
            for (int j = 1; j < string.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == string.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(string.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
    }
}
