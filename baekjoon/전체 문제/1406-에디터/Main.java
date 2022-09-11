import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String string = br.readLine(); // N = string.length()

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < string.length(); i++) {
            leftStack.push(string.charAt(i));
        }

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "L": {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                }
                case "D": {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                }
                case "B": {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                }
                case "P": {
                    leftStack.push(st.nextToken().charAt(0));
                    break;
                }
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
